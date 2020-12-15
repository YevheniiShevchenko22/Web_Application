package pl.edu.wszib.iphonestore.database;

import pl.edu.wszib.iphonestore.model.User;

/**
 * Created by Yevhenii Shevchenko at 12/14/20
 * Project name: iphonestore
 **/
public interface IUserRepository {
    User authenticate(User user);
}
