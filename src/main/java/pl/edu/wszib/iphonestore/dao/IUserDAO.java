package pl.edu.wszib.iphonestore.dao;

import pl.edu.wszib.iphonestore.model.User;

/**
 * Created by Yevhenii Shevchenko at ${DATE}
 * Project name: ${PROJECT_NAME}
 **/
public interface IUserDAO {

    User getUserByLogin (String login);

    boolean persistUser(User user);
}
