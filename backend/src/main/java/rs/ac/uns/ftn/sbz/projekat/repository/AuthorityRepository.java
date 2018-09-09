package rs.ac.uns.ftn.sbz.projekat.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.sbz.projekat.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {


    Authority findByName(String ime);
}
