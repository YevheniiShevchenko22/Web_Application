package pl.edu.wszib.iphonestore.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import pl.edu.wszib.iphonestore.dao.ICreateAdminAccount;
import pl.edu.wszib.iphonestore.dao.ICreateProduct;
import pl.edu.wszib.iphonestore.model.Product;
import pl.edu.wszib.iphonestore.model.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Yevhenii Shevchenko at 12/9/20
 * Project name: iphonestore
 **/

@Configuration
@ComponentScan("pl.edu.wszib.iphonestore")
public class AppConfiguration {

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/iphonestore");
        dataSource.setUsername("root");
        dataSource.setPassword("");

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }

    @Bean
    CommandLineRunner commandLineRunner(ICreateAdminAccount createAdminAccount){
        return args -> {
            User admin = new User();
            admin.setLogin("admin");
            admin.setPass("admin");
            admin.setRole(User.Role.ADMIN.name());
            createAdminAccount.save(admin);
        };
    }

    @Bean
    CommandLineRunner commandLineRunner1 (ICreateProduct createProduct){
        return args -> {
            Product newProduct1 = new Product(
                    0,
                    "IPhone 11",
                    "123456789",
                    30,
                    "iphone11.jpeg",
                    1300.49
            );
            Product newProduct2 = new Product(
                    0,
                    "IPhone X",
                    "123456889",
                    25,
                    "iphone_x.jpeg",
                    1499.99
            );
            createProduct.save(newProduct1);
            createProduct.save(newProduct2);

        };
    }
}
