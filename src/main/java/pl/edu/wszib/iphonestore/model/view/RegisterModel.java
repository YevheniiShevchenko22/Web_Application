package pl.edu.wszib.iphonestore.model.view;

import pl.edu.wszib.iphonestore.model.User;

/**
 * Created by Yevhenii Shevchenko at 12/21/20
 * Project name: iphonestore
 **/
public class RegisterModel {

    private String login;
    private String pass;
    private String pass2;

    public RegisterModel() {

    }

    public RegisterModel(String login, String pass, String pass2) {
        this.login = login;
        this.pass = pass;
        this.pass2 = pass2;
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

    public String getPass2() {
        return pass2;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }

    public User toUser(RegisterModel registerModel){
        return new User(1, registerModel.getLogin(), registerModel.getPass(), User.Role.USER);
    }
}

