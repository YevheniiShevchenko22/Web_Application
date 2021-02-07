package pl.edu.wszib.iphonestore.service.impl;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.edu.wszib.iphonestore.configuration.AppConfiguration;
import pl.edu.wszib.iphonestore.configuration.TestAppConfiguration;
import pl.edu.wszib.iphonestore.configuration.WebConfiguration;
import pl.edu.wszib.iphonestore.dao.IProductDAO;
import pl.edu.wszib.iphonestore.dao.IUserDAO;
import pl.edu.wszib.iphonestore.model.User;
import pl.edu.wszib.iphonestore.model.view.RegisterModel;
import pl.edu.wszib.iphonestore.service.IUserService;
import pl.edu.wszib.iphonestore.session.SessionObject;

import javax.annotation.Resource;


/**
 * Created by Yevhenii Shevchenko at 2/7/21
 * Project name: iphonestore
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {TestAppConfiguration.class})
public class UserServiceImplTest {

    @MockBean
    IProductDAO productDAO;

    @MockBean
    IUserDAO userDAO;

    @Autowired
    IUserService userService;

    @Resource
    SessionObject sessionObject;

    @Test
    public void registerTest(){

        RegisterModel registerModel = new RegisterModel();
        registerModel.setLogin("massage");
        registerModel.setPass("massage123");
        registerModel.setPass2("massage123");

        Mockito.when(this.userDAO.getUserByLogin("massage")).thenReturn(null);
        Mockito.when(this.userDAO.persistUser(ArgumentMatchers.any())).thenReturn(true);

        boolean result = userService.register(registerModel);

        Assert.assertTrue(result);
    }

    public void registerLoginIncorrectTest(){
        RegisterModel registerModel = new RegisterModel();
        registerModel.setLogin("piotrek");
        registerModel.setPass("piotrek123");
        registerModel.setPass2("pioterk123");

        Mockito.when(this.userDAO.getUserByLogin("piotrek")).thenReturn(new User());

        boolean result = userService.register(registerModel);

        Assert.assertFalse(result);
    }

    @Test
    public void correctAutheficationTest(){
        User user = new User();
        user.setLogin("admin");
        user.setPass("admin");

        Mockito.when(this.userDAO.getUserByLogin("admin")).thenReturn(generateUser());

        this.userService.authenticate(user);

        Assert.assertNotNull(this.sessionObject.getLoggedUser());
    }

    @Test
    public void IncorrectLoginAuthentication(){
        User user = new User();
        user.setLogin("nelson");
        user.setPass("nelson111");

        Mockito.when(this.userDAO.getUserByLogin("nelson")).thenReturn(null);

        this.userService.authenticate(user);

        Assert.assertNull(this.sessionObject.getLoggedUser());
    }

    @Test
    public void incorrectPassTest(){
        User user = new User();
        user.setLogin("mateusz");
        user.setPass("mateusz333");

        Mockito.when(this.userDAO.getUserByLogin("mateusz")).thenReturn(generateUser());

        this.userService.authenticate(user);

        Assert.assertNull(this.sessionObject.getLoggedUser());
    }

    private User generateUser(){
        User user = new User();
        user.setId(3);
        user.setLogin("admin");
        user.setPass("admin");
        user.setRole(User.Role.USER.name());

        return user;
    }
}