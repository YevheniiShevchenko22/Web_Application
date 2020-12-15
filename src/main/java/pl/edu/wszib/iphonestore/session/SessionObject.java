package pl.edu.wszib.iphonestore.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import pl.edu.wszib.iphonestore.model.User;

/**
 * Created by Yevhenii Shevchenko at 12/15/20
 * Project name: iphonestore
 **/
@Component
@SessionScope
public class SessionObject {

    private User loggedUser = null;

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    public boolean isLogged(){
        return this.loggedUser != null;
    }
}
