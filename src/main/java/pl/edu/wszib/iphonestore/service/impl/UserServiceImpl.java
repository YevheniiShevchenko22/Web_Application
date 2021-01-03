package pl.edu.wszib.iphonestore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.iphonestore.dao.IUserDAO;
import pl.edu.wszib.iphonestore.model.User;
import pl.edu.wszib.iphonestore.model.view.RegisterModel;
import pl.edu.wszib.iphonestore.service.IUserService;
import pl.edu.wszib.iphonestore.session.SessionObject;

import javax.annotation.Resource;

/**
 * Created by Yevhenii Shevchenko at ${DATE}
 * Project name: ${PROJECT_NAME}
 **/
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDAO userDAO;

    @Resource
    SessionObject sessionObject;

    @Override
    public void authenticate(User user) {
        User userFromDB = this.userDAO.getUserByLogin(user.getLogin());

        if (userFromDB == null){
            return;
        }

        if (user.getPass().equals(userFromDB.getPass())){
            this.sessionObject.setLoggedUser(userFromDB);
        }
    }

    @Override
    public void logout() {
        this.sessionObject.clearBasket();
        this.sessionObject.setLoggedUser(null);
    }

    @Override
    public boolean register(RegisterModel registerModel) {

        if ( this.userDAO.getUserByLogin(registerModel.getLogin()) != null){
            return false;
        }

        User newUser = registerModel.toUser(registerModel);

        return this.userDAO.persistUser(newUser);
    }
}
