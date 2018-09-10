package rs.ac.uns.ftn.sbz.projekat;

import org.drools.core.ClassObjectFilter;
import org.drools.core.time.SessionPseudoClock;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import rs.ac.uns.ftn.sbz.projekat.events.AcceleratedHeartRate;
import rs.ac.uns.ftn.sbz.projekat.events.Heartbeat;
import rs.ac.uns.ftn.sbz.projekat.events.IntensiveCare;
import rs.ac.uns.ftn.sbz.projekat.model.Diagnosis;
import rs.ac.uns.ftn.sbz.projekat.model.Disease;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class AcceleratedHeartRateTest {

    @Test
    public void test() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        runPseudoClock(kContainer.newKieSession("kSessionPseudoClock"));
    }

    private void runPseudoClock(KieSession ksession) {
        String jmbg = "86494";

        IntensiveCare intensiveCare = new IntensiveCare();
        intensiveCare.setJmbg(jmbg);
        intensiveCare.setOxygenLevel(120);
        SessionPseudoClock clock = ksession.getSessionClock();
        Diagnosis diagnosis = new Diagnosis();
        Disease disease = new Disease();
        disease.setName("disease");
        diagnosis.setDisease(disease);
        intensiveCare.setDiagnosis(diagnosis);

        ksession.insert(intensiveCare);

        for (int index = 0; index < 23; index++) {
            ksession.insert(new Heartbeat(jmbg));

            clock.advanceTime(1, TimeUnit.SECONDS);

            int ruleCount = ksession.fireAllRules();
            assertThat(ruleCount, equalTo(0));
        }

        clock.advanceTime(1, TimeUnit.SECONDS);
        for (int index = 0; index < 40; index++) {
            ksession.insert(new Heartbeat(jmbg));
        }

        clock.advanceTime(9, TimeUnit.SECONDS);
        int ruleCount = ksession.fireAllRules();
        assertThat(ruleCount, equalTo(1));

        Collection<?> newEvents = ksession.getObjects(new ClassObjectFilter(AcceleratedHeartRate.class));
        assertThat(newEvents.size(), equalTo(1));
    }
}
