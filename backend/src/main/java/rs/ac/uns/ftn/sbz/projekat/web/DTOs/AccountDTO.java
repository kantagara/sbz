package rs.ac.uns.ftn.sbz.projekat.web.DTOs;

import rs.ac.uns.ftn.sbz.projekat.model.Account;

public class AccountDTO {

    private String username;

    private String password;

    private String ime;

    private String prezime;

    public AccountDTO(){}

    public AccountDTO(String username, String password, String ime, String prezime) {
        this.username = username;
        this.password = password;
        this.ime = ime;
        this.prezime = prezime;
    }

    public AccountDTO(Account account) {
        this.ime = account.getName();
        this.prezime = account.getSurname();
        this.username = account.getUsername();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
}
