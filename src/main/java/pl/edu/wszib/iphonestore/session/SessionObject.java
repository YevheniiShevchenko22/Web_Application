package pl.edu.wszib.iphonestore.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import pl.edu.wszib.iphonestore.model.Product;
import pl.edu.wszib.iphonestore.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yevhenii Shevchenko at 12/15/20
 * Project name: iphonestore
 **/
@Component
@SessionScope
public class SessionObject {

    private User loggedUser = null;
    private String info = null;
    private final List<Product> bascket = new ArrayList<>();

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    public boolean isLogged(){
        return this.loggedUser != null;
    }

    public String getInfo() {
        String temp = this.info;
        this.info = null;
        return temp;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<Product> getBasked() {
        return bascket;
    }

    public void clearBasket(){
        bascket.clear();
    }
}


