package pl.edu.wszib.iphonestore.configuration;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.edu.wszib.iphonestore.dao.IProductDAO;
import pl.edu.wszib.iphonestore.dao.IUserDAO;
import pl.edu.wszib.iphonestore.dao.impl.ProductDaoStub;
import pl.edu.wszib.iphonestore.dao.impl.UserDaoStub;
import pl.edu.wszib.iphonestore.model.User;

/**
 * Created by Yevhenii Shevchenko at 2/7/21
 * Project name: iphonestore
 **/

@Configuration
@ComponentScan(basePackages = {
        "pl.edu.wszib.iphonestore.controllers",
        "pl.edu.wszib.iphonestore.session",
        "pl.edu.wszib.iphonestore.service.impl"

})
public class TestAppConfiguration {
/*
    @Bean
    public IProductDAO productDAO(){
        return Mockito.mock(IProductDAO.class);
    }

    @Bean
    public IUserDAO userDAO(){
        return Mockito.mock(IUserDAO.class);
    }*/
}
