package pl.edu.wszib.iphonestore.database.impl;

import org.springframework.stereotype.Component;
import pl.edu.wszib.iphonestore.database.IUserRepository;
import pl.edu.wszib.iphonestore.model.Role;
import pl.edu.wszib.iphonestore.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yevhenii Shevchenko at 12/14/20
 * Project name: iphonestore
 **/
@Component
public class UserRepository implements IUserRepository {

    private final List<User> users = new ArrayList<>();

    public UserRepository() {
        users.add(new User(1, "bob", "bob", Role.USER));
        users.add(new User(2, "admin", "admin", Role.ADMIN));
    }

    @Override
    public User authenticate(User user) {
        for (User userFromDB : this.users) {
            if (userFromDB.getLogin().equals(user.getLogin())
                && userFromDB.getPass().equals(user.getPass())){
                return userFromDB;
            }
        }
        return null;
    }

    @Override
    public boolean register(User user) {
        if (isUserInDB(user.getLogin())){
            return false;
        }

        this.users.add(user);
        return true;
    }
    
    private boolean isUserInDB(String login){
        for (User user: users ) {
            if (user.getLogin().equals(login)){
                return true;
            }
        }
        return false;
    }
}
