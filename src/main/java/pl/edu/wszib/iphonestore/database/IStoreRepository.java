package pl.edu.wszib.iphonestore.database;

import pl.edu.wszib.iphonestore.model.Product;

import java.util.List;

/**
 * Created by Yevhenii Shevchenko at 12/10/20
 * Project name: iphonestore
 **/
public interface IStoreRepository {

    List<Product> getAllProduct();
    Product getProductByCodeEAN(String codeEAN);
    void updateProduct(Product product);

    Product getProductById(int id);

    void save(Product product);
}
