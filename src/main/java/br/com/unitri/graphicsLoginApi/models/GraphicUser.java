package br.com.unitri.graphicsLoginApi.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
public class GraphicUser implements UserDetails {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column( nullable = false, unique = true )
    private String login;

    @Column ( nullable = false )
    private String password;

    @PastOrPresent
    @Column ( nullable = false )
    private LocalDateTime registerDate;

    private final static String salt = BCrypt.gensalt(10);

    public GraphicUser(String login , CleanPassword password ) {
        this.login = login;
        this.password = new BCryptPasswordEncoder().encode(password.getPasswordPlainText());
        registerDate = LocalDateTime.now();
    }

    @Deprecated
    public GraphicUser() {

    }

    public Long getId () {
        return id;
    }

    public String getLogin () {
        return login;
    }

    public LocalDateTime getRegisterDate () {
        return registerDate;
    }

    @Override public String getPassword () {
        return password;
    }

    @Override public String getUsername () {
        return login;
    }

    @Override public Collection<? extends GrantedAuthority> getAuthorities () {
        return null;
    }

    @Override public boolean isAccountNonExpired () {
        return true;
    }

    @Override public boolean isAccountNonLocked () {
        return true;
    }

    @Override public boolean isCredentialsNonExpired () {
        return true;
    }

    @Override public boolean isEnabled () {
        return true;
    }

    @Override public String toString () {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", dataCadastro=" + registerDate +
                '}';
    }
}
