package rs.ac.uns.ftn.sbz.projekat.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import rs.ac.uns.ftn.sbz.projekat.model.Disease;

import java.util.List;

public interface DiseaseRepository extends JpaRepository<Disease, Long> {

    Disease findByName(String name);

    @Query(value = "SELECT * FROM DISEASE D WHERE D.ID IN (SELECT DISEASE_ID FROM disease_general_symptoms dgs WHERE dgs.general_symptoms_id = :id) ", nativeQuery = true)
    List<Disease> findAllWhoContainSymptom(@Param("id") Long id);
}
