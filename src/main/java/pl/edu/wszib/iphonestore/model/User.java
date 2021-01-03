package pl.edu.wszib.iphonestore.model;


import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Created by Yevhenii Shevchenko at 12/14/20
 * Project name: iphonestore
 **/

@Entity(name = "User")
@Table(name = "tuser")
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(
            name = "login",
            nullable = false,
            length = 100
    )
    private String login;

    @Column(
            name = "pass",
            nullable = false,
            length = 100
    )
    private String pass;

    @Column(
            name = "role",
            nullable = false,
            columnDefinition = "varchar(10)"
    )
    private String role;

    public User() {
    }

    public User(Integer id, String login, String pass, Role role) {
        this.id = id;
        this.login = login;
        this.pass = pass;
        this.role = role.name();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public enum Role {
        USER,
        ADMIN
    }

}
