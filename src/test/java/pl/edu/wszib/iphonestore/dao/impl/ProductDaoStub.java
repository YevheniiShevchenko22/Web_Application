package pl.edu.wszib.iphonestore.dao.impl;

import pl.edu.wszib.iphonestore.dao.IProductDAO;
import pl.edu.wszib.iphonestore.model.Product;

import java.util.List;

/**
 * Created by Yevhenii Shevchenko at 2/7/21
 * Project name: iphonestore
 **/
public class ProductDaoStub implements IProductDAO {
    @Override
    public Product getProductById(int id) {
        return null;
    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void save(Product product) {

    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }
}
