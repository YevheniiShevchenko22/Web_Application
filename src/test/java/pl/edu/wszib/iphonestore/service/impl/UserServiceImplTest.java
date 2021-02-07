package pl.edu.wszib.iphonestore.service.impl;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
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
import pl.edu.wszib.iphonestore.model.view.RegisterModel;
import pl.edu.wszib.iphonestore.service.IUserService;


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
}