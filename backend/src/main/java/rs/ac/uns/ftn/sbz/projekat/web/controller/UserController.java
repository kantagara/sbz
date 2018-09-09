package rs.ac.uns.ftn.sbz.projekat.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.sbz.projekat.model.Account;
import rs.ac.uns.ftn.sbz.projekat.model.Authority;
import rs.ac.uns.ftn.sbz.projekat.security.JWTUtils;
import rs.ac.uns.ftn.sbz.projekat.service.AccountService;
import rs.ac.uns.ftn.sbz.projekat.web.DTOs.AccountDTO;
import rs.ac.uns.ftn.sbz.projekat.web.DTOs.LoginDTO;
import rs.ac.uns.ftn.sbz.projekat.web.DTOs.TokenDTO;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;


    @PostMapping(
            value = "/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity login(
            @RequestBody LoginDTO loginDTO) {
        try {
            System.out.println(loginDTO.toString());
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                    loginDTO.getUsername(), loginDTO.getPassword());
            authenticationManager.authenticate(token);
            Account account = this.accountService.findByUsername(loginDTO.getUsername());
            System.out.println(account.getAccountAuthorities().get(0).getAuthority().getName());
            UserDetails details = userDetailsService.loadUserByUsername(account.getUsername());

            TokenDTO userToken = new TokenDTO(jwtUtils.generateToken(details));
            System.out.println(userToken.getValue());
            return new ResponseEntity<>(userToken, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity register(@RequestBody AccountDTO accountDTO, @RequestParam boolean isAdmin){

        if(this.accountService.usernameExists(accountDTO.getUsername())){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        accountService.registerUser(accountDTO, isAdmin ? "ADMIN" : "DOKTOR");

        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping(
            value = "/change",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity changeAccount(@RequestBody AccountDTO accountDTO) {

        this.accountService.changeAccount(accountDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping(value = "/all",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllByRole(@RequestParam String role){

        List<Account> accounts = this.accountService.findByRole(role);
        List<AccountDTO> dtos = new ArrayList<>();

        for (Account account :
                accounts) {
            dtos.add(new AccountDTO(account));
        }

        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @DeleteMapping(
            value = "/",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity delete(@RequestParam String username){

        boolean deleted = this.accountService.delete(username);

        return new ResponseEntity(deleted ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}
