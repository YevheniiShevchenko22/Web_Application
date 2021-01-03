package pl.edu.wszib.iphonestore.service;


import org.springframework.web.multipart.MultipartFile;
import pl.edu.wszib.iphonestore.model.Product;

import java.io.IOException;
import java.util.List;

/**
 * Created by Yevhenii Shevchenko at ${DATE}
 * Project name: ${PROJECT_NAME}
 **/

public interface IStoreService {

    Product getProductById(int id);

    void updateProduct(Product product);

    void saveProduct(Product product, MultipartFile multipartFile) throws IOException;

    List<Product> getAllProducts();
}
