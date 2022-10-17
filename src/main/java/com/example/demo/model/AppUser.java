package com.example.demo.model;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="users")
public class AppUser {
    @Id
    private Long id;
    private String username;
    private int age;
    //private enum Sex;
    private String email;
    private String zipcode;
    private int number; //dit is het huisnummer
    private String city;
    private boolean wantsNewsletter;
    private String password;
    public boolean hasTooManyWrongLogins;


    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Collection<Order> orders;
    
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

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }




}
