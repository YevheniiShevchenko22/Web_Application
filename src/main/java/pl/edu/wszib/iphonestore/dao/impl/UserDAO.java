package pl.edu.wszib.iphonestore.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.iphonestore.dao.ICreateAdminAccount;
import pl.edu.wszib.iphonestore.dao.ICreateProduct;
import pl.edu.wszib.iphonestore.dao.IUserDAO;
import pl.edu.wszib.iphonestore.model.User;

/**
 * Created by Yevhenii Shevchenko at ${DATE}
 * Project name: ${PROJECT_NAME}
 **/
@Repository
public class UserDAO implements IUserDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public User getUserByLogin(String login) {
        return jdbcTemplate.query("SELECT * FROM tuser WHERE login = ?", new BeanPropertyRowMapper<>(User.class), login)
                .stream().findAny().orElse(null);
    }

    @Override
    public boolean persistUser(User user) {
        jdbcTemplate.update("INSERT INTO tuser VALUES (0,?,?,?)", user.getLogin(), user.getPass(), user.getRole().toString());
        return true;
    }
}
