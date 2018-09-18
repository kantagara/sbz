package rs.ac.uns.ftn.sbz.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.sbz.projekat.model.Account;
import rs.ac.uns.ftn.sbz.projekat.model.AccountAuthority;
import rs.ac.uns.ftn.sbz.projekat.model.Authority;
import rs.ac.uns.ftn.sbz.projekat.repository.AccountAuthorityRepository;
import rs.ac.uns.ftn.sbz.projekat.repository.AccountRepository;
import rs.ac.uns.ftn.sbz.projekat.repository.AuthorityRepository;
import rs.ac.uns.ftn.sbz.projekat.security.JWTUtils;
import rs.ac.uns.ftn.sbz.projekat.web.DTOs.AccountDTO;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private AccountAuthorityRepository accountAuthorityRepository;

    @Autowired
    private JWTUtils jwtUtils;

    @Override
    public boolean usernameExists(String username) {
        Account account = this.accountRepository.findByUsername(username);
        return account != null;
    }

    @Override
    public List<Account> findAll() {
        return this.accountRepository.findAll();
    }

    @Override
    public Account findOne(Long id) {
        return this.accountRepository.getOne(id);
    }

    @Override
    public Account save(Account account) {
        return this.accountRepository.save(account);
    }

    @Override
    public Account findByUsername(String username) {
        return this.accountRepository.findByUsername(username);
    }

    @Override
    public void remove(Account account) {
        this.accountRepository.delete(account.getId());
    }

    @Override
    public void registerUser(AccountDTO accountDTO, String role) {
        Account account = new Account(accountDTO.getUsername(),
                BCrypt.hashpw(accountDTO.getPassword(), BCrypt.gensalt()),
                accountDTO.getName(), accountDTO.getSurname());

        Authority authority = authorityRepository.findByName(role);
        AccountAuthority accountAuthority = new AccountAuthority(account, authority);

        accountRepository.save(account);
        accountAuthorityRepository.save(accountAuthority);
    }

    @Override
    public void changeAccount(AccountDTO accountDTO) {
        Account account = findByUsername(accountDTO.getUsername());
        account.setName(accountDTO.getName());
        account.setSurname(accountDTO.getSurname());
        System.out.println(account);
        save(account);
    }

    @Override
    public List<Account> findByRole(String role) {
        return accountRepository.findAllByRole(role);
    }

    @Override
    public boolean delete(String username) {
        Account account = findByUsername(username);
        if(account == null)
           return false;

        AccountAuthority authority = accountAuthorityRepository.findByAccountId(account.getId());
        accountAuthorityRepository.delete(authority);
        remove(account);

        return true;
    }


}
