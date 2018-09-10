package rs.ac.uns.ftn.sbz.projekat.model;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Katarina Cukurov on 28/03/2018.
 */
@Entity
@Table(name = "account")
@Where(clause="deleted=0")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    @Version
    private int version;

    @Column(nullable = false, columnDefinition = "BOOL DEFAULT FALSE")
    private boolean deleted;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private List<AccountAuthority> accountAuthorities;

    public Account(){
        this.accountAuthorities = new ArrayList<>();
    }

    public Account(String username, String password, String name, String surname) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.accountAuthorities = new ArrayList<>();
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public int getVersion() { return version; }

    public void setVersion(int version) { this.version = version; }

    public boolean isDeleted() { return deleted; }

    public void setDeleted(boolean deleted) { this.deleted = deleted; }


    public List<AccountAuthority> getAccountAuthorities() {
        return accountAuthorities;
    }

    public void setAccountAuthorities(List<AccountAuthority> accountAuthorities) {
        this.accountAuthorities = accountAuthorities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
