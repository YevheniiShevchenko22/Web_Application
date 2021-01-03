package pl.edu.wszib.iphonestore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.iphonestore.dao.IProductDAO;
import pl.edu.wszib.iphonestore.model.Product;
import pl.edu.wszib.iphonestore.service.IBasketService;
import pl.edu.wszib.iphonestore.session.SessionObject;

import javax.annotation.Resource;

/**
 * Created by Yevhenii Shevchenko at ${DATE}
 * Project name: ${PROJECT_NAME}
 **/
@Service
public class BasketServiceImpl implements IBasketService {

    @Autowired
    IProductDAO productDAO;

    @Resource
    SessionObject sessionObject;

    @Override
    public double calculateTotal() {
        double sum = 0;
        for (Product product :
                this.sessionObject.getBasked()) {
            sum = sum + product.getPrice()* product.getAmount();
        }
        return sum;
    }

    @Override
    public void addBookByIdToBasket(int id) {
        Product product = this.productDAO.getProductById(id);
        for (Product productFromBasket : this.sessionObject.getBasked()){
            if(productFromBasket.getId() == product.getId()){
                productFromBasket.setAmount(productFromBasket.getAmount() + 1);
                return;
            }
        }

        product.setAmount(1);
        this.sessionObject.getBasked().add(product);
    }
}
