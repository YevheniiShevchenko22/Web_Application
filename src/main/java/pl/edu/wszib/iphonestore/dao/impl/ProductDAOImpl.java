package pl.edu.wszib.iphonestore.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.iphonestore.dao.IProductDAO;
import pl.edu.wszib.iphonestore.model.Product;

import java.util.List;

/**
 * Created by Yevhenii Shevchenko at ${DATE}
 * Project name: ${PROJECT_NAME}
 **/
@Repository
public class ProductDAOImpl implements IProductDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Product getProductById(int id) {
        return jdbcTemplate.query("SELECT * FROM tproduct WHERE id = ?", new BeanPropertyRowMapper<>(Product.class), id )
                .stream().findAny().orElse(null);
    }

    @Override
    public void updateProduct(Product product) {
        jdbcTemplate.update("UPDATE tproduct SET name=?, codeEAN=?, amount=?, price=? WHERE id=?",
                product.getName(), product.getCodeEAN(), product.getAmount(), product.getPrice(), product.getId());
    }

    @Override
    public void save(Product product) {
        jdbcTemplate.update("INSERT INTO tproduct VALUES (0,?,?,?,?,?)", product.getAmount(), product.getCodeEAN(), product.getName(), product.getPic(), product.getPrice());
    }

    @Override
    public List<Product> getAllProducts() {
        return jdbcTemplate.query("SELECT * FROM tproduct", new BeanPropertyRowMapper<>(Product.class));
    }
}
