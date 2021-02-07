package pl.edu.wszib.iphonestore.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.edu.wszib.iphonestore.configuration.AppConfiguration;
import pl.edu.wszib.iphonestore.configuration.WebConfiguration;
import pl.edu.wszib.iphonestore.dao.IProductDAO;
import pl.edu.wszib.iphonestore.dao.IUserDAO;
import pl.edu.wszib.iphonestore.model.Product;
import pl.edu.wszib.iphonestore.service.IBasketService;
import pl.edu.wszib.iphonestore.session.SessionObject;

import javax.annotation.Resource;


/**
 * Created by Yevhenii Shevchenko at 2/7/21
 * Project name: iphonestore
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfiguration.class, WebConfiguration.class})
@WebAppConfiguration
public class BasketServiceImplTest {

    @MockBean
    IProductDAO productDAO;

    @MockBean
    IUserDAO userDAO;

    @Autowired
    IBasketService basketService;

    @Resource
    SessionObject sessionObject;

    @Test
    public void calculateTotal() {
        sessionObject.getBasked().add(new Product(1,
                "IPhone 11",
                "123456789",
                2,
                "iphone_11.jpg",
                1299.99));
        sessionObject.getBasked().add(new Product(2,
                "IPhone 12",
                "123423789",
                1,
                "iphone_12.jpg",
                1499.99));
        sessionObject.getBasked().add(new Product(3,
                "IPhone SE",
                "177456789",
                1,
                "iphone_se.jpg",
                899.99));

        double expectedRes = 4_999.96;
        double res = basketService.calculateTotal();

        Assert.assertEquals(expectedRes, res, 0.01 );
    }

}