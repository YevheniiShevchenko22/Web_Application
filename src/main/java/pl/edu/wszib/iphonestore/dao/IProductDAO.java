package pl.edu.wszib.iphonestore.dao;

import pl.edu.wszib.iphonestore.model.Product;

import java.util.List;

/**
 * Created by Yevhenii Shevchenko at ${DATE}
 * Project name: ${PROJECT_NAME}
 **/
public interface IProductDAO {

    Product getProductById(int id);

    void updateProduct(Product product);

    void save(Product product);

    List<Product> getAllProducts();
}
