package pl.edu.wszib.iphonestore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import pl.edu.wszib.iphonestore.dao.IProductDAO;
import pl.edu.wszib.iphonestore.model.FileUploadUtil;
import pl.edu.wszib.iphonestore.model.Product;
import pl.edu.wszib.iphonestore.service.IStoreService;

import java.io.IOException;
import java.util.List;

/**
 * Created by Yevhenii Shevchenko at ${DATE}
 * Project name: ${PROJECT_NAME}
 **/
@Service
public class StoreServiceImpl implements IStoreService {

    @Autowired
    IProductDAO productDAO;

    @Override
    public Product getProductById(int id) {
        return this.productDAO.getProductById(id);
    }

    @Override
    public void updateProduct(Product product) {

        Product productFromDB = this.productDAO.getProductById(product.getId());
        productFromDB.setName(product.getName());
        productFromDB.setCodeEAN(product.getCodeEAN());
        productFromDB.setAmount(product.getAmount());
        productFromDB.setPrice(product.getPrice());

        this.productDAO.updateProduct(productFromDB);
    }

    @Override
    public void saveProduct(Product product, MultipartFile multipartFile) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        product.setPic(fileName);
        productDAO.save(product);
        String uploadDir = "src/main/resources/static/images/product/";
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

    }

    @Override
    public List<Product> getAllProducts() {
        return this.productDAO.getAllProducts();
    }
}
