package rs.ac.uns.ftn.sbz.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import rs.ac.uns.ftn.sbz.projekat.model.Account;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByUsername(String username);

    @Query(value = "SELECT * FROM ACCOUNT WHERE ACCOUNT.ID IN " +
            "(SELECT aa.account_id FROM ACCOUNT_AUTHORITY " +
            "aa WHERE aa.AUTHORITY_ID IN (SELECT ID FROM AUTHORITY WHERE AUTHORITY.NAME = :role))",nativeQuery = true)
    List<Account> findAllByRole(@Param("role") String role);
}
