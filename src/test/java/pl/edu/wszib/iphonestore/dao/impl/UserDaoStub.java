package pl.edu.wszib.iphonestore.dao.impl;

import pl.edu.wszib.iphonestore.dao.IUserDAO;
import pl.edu.wszib.iphonestore.model.User;

/**
 * Created by Yevhenii Shevchenko at 2/7/21
 * Project name: iphonestore
 **/
public class UserDaoStub implements IUserDAO {
    @Override
    public User getUserByLogin(String login) {
        return null;
    }

    @Override
    public boolean persistUser(User user) {
        return true;
    }
}
