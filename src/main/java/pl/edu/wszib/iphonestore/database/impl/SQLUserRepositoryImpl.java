package pl.edu.wszib.iphonestore.database.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import pl.edu.wszib.iphonestore.database.IUserRepository;
import pl.edu.wszib.iphonestore.model.Product;
import pl.edu.wszib.iphonestore.model.User;

/**
 * Created by Yevhenii Shevchenko at ${DATE}
 * Project name: ${PROJECT_NAME}
 **/
@Component
public class SQLUserRepositoryImpl implements IUserRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SQLUserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User authenticate(User user) {
        User userFromDB = jdbcTemplate.query("SELECT * FROM tuser WHERE login = ?", new BeanPropertyRowMapper<>(User.class), user.getLogin())
                .stream().findAny().orElse(null);
        if (userFromDB.getPass().equals(user.getPass())){
            return userFromDB;
        }
        return null;
    }

    @Override
    public boolean register(User user) {
        if (isUserInDB(user.getLogin())){
            return false;
        }
        jdbcTemplate.update("INSERT INTO tuser VALUES (0,?,?,?)", user.getLogin(), user.getPass(), user.getRole().toString());
        return true;
    }

    private boolean isUserInDB(String login){
        if (jdbcTemplate.query("SELECT * FROM tuser WHERE login = ?", new BeanPropertyRowMapper<>(User.class), login)
                .iterator().hasNext()){
            return true;
        }
        return false;
    }
}
