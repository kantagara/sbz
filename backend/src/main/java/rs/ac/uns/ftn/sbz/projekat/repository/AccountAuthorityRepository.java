package rs.ac.uns.ftn.sbz.projekat.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.sbz.projekat.model.AccountAuthority;

public interface AccountAuthorityRepository extends JpaRepository<AccountAuthority, Long> {

    AccountAuthority findByAccountId(Long accountId);
}
