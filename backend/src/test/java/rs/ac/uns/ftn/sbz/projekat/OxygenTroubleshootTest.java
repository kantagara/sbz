package rs.ac.uns.ftn.sbz.projekat;

import org.drools.core.ClassObjectFilter;
import org.drools.core.time.SessionPseudoClock;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import rs.ac.uns.ftn.sbz.projekat.events.IntensiveCare;
import rs.ac.uns.ftn.sbz.projekat.events.OxygenLevelIncrease;
import rs.ac.uns.ftn.sbz.projekat.model.Diagnosis;
import rs.ac.uns.ftn.sbz.projekat.model.Disease;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class OxygenTroubleshootTest {

    @Test
    public void oxygenTroubleshoot() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        runPseudoClock(kContainer.newKieSession("kSessionPseudoClock"));
    }

    private void runPseudoClock(KieSession ksession) {
        String jmbg = "230394";

        IntensiveCare intensiveCare = new IntensiveCare();
        intensiveCare.setJmbg(jmbg);
        intensiveCare.setOxygenLevel(20);
        SessionPseudoClock clock = ksession.getSessionClock();
        Diagnosis diagnosis = new Diagnosis();
        Disease disease = new Disease();
        disease.setName("disease");
        diagnosis.setDisease(disease);
        intensiveCare.setDiagnosis(diagnosis);

        ksession.insert(intensiveCare);

        for (int index = 0; index < 30; index++) {
            ksession.insert(new OxygenLevelIncrease(jmbg, 1.0));
            clock.advanceTime(1, TimeUnit.SECONDS);
            int ruleCount = ksession.fireAllRules();
            assertThat(ruleCount, equalTo(0));
        }

        clock.advanceTime(15, TimeUnit.MINUTES);
        int ruleCount = ksession.fireAllRules();
        assertThat(ruleCount, equalTo(1));

        IntensiveCare intensiveCare1 = new IntensiveCare();
        intensiveCare1.setDiagnosis(diagnosis);
        intensiveCare1.setJmbg("230394");
        intensiveCare1.setOxygenLevel(80);

        for (int index = 0; index < 30; index++) {
            ksession.insert(new OxygenLevelIncrease("230349", 1.0));
            clock.advanceTime(1, TimeUnit.SECONDS);
            ruleCount = ksession.fireAllRules();
            assertThat(ruleCount, equalTo(0));
        }

        clock.advanceTime(15, TimeUnit.MINUTES);
        ruleCount = ksession.fireAllRules();
        assertThat(ruleCount, equalTo(0));

        ksession.insert(intensiveCare1);

        Collection<?> newEvents = ksession.getObjects(new ClassObjectFilter(IntensiveCare.class));
        assertThat(newEvents.size(), equalTo(2));
    }

}
