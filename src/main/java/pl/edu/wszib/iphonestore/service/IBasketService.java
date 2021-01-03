package pl.edu.wszib.iphonestore.service;

/**
 * Created by Yevhenii Shevchenko at ${DATE}
 * Project name: ${PROJECT_NAME}
 **/
public interface IBasketService {

    double calculateTotal();

    void addBookByIdToBasket(int id);
}
