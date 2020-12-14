package pl.edu.wszib.iphonestore.model;


/**
 * Created by Yevhenii Shevchenko at 12/14/20
 * Project name: iphonestore
 **/
public class User {

    private int id;
    private String login;
    private String pass;
    private Role role;

    public User() {
    }

    public User(int id, String login, String pass, Role role) {
        this.id = id;
        this.login = login;
        this.pass = pass;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
