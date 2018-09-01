package rs.ac.uns.ftn.sbz.projekat.service;


import rs.ac.uns.ftn.sbz.projekat.model.Account;

import java.util.List;

public interface AccountService {

    boolean usernameExists(String username);

    List<Account> findAll();

    Account findOne(Long id);

    Account save(Account account);

    Account findByUsername(String username);

    void remove(Account account);


}
