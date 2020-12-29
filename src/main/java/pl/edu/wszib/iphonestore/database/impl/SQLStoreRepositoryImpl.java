package pl.edu.wszib.iphonestore.database.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import pl.edu.wszib.iphonestore.database.IStoreRepository;
import pl.edu.wszib.iphonestore.model.Product;

import java.util.List;

/**
 * Created by Yevhenii Shevchenko at ${DATE}
 * Project name: ${PROJECT_NAME}
 **/
@Component
public class SQLStoreRepositoryImpl implements IStoreRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SQLStoreRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> getAllProduct() {

        return jdbcTemplate.query("SELECT * FROM tproduct", new BeanPropertyRowMapper<>(Product.class));
    }

    @Override
    public Product getProductByCodeEAN(String codeEAN) {
        return jdbcTemplate.query("SELECT * FROM tproduct WHERE id = ?", new BeanPropertyRowMapper<>(Product.class),codeEAN)
                .stream().findAny().orElse(null);
    }

    @Override
    public void updateProduct(Product product) {
        jdbcTemplate.update("UPDATE tproduct SET name=?, codeEAN=?, amount=?, price=? WHERE id=?",
                product.getName(), product.getCodeEAN(), product.getAmount(), product.getPrice(), product.getId());
    }

    @Override
    public Product getProductById(int id) {
        return jdbcTemplate.query("SELECT * FROM tproduct WHERE id = ?", new BeanPropertyRowMapper<>(Product.class), id )
                .stream().findAny().orElse(null);
    }

    @Override
    public void save(Product product) {
        jdbcTemplate.update("INSERT INTO tproduct VALUES (0,?,?,?,?,?)", product.getName(), product.getCodeEAN(), product.getAmount(), product.getPic(), product.getPrice());
    }

}
