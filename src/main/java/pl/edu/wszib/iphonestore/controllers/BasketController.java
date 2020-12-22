package pl.edu.wszib.iphonestore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.edu.wszib.iphonestore.database.IStoreRepository;
import pl.edu.wszib.iphonestore.model.Product;
import pl.edu.wszib.iphonestore.session.SessionObject;

import javax.annotation.Resource;

/**
 * Created by Yevhenii Shevchenko at 12/21/20
 * Project name: iphonestore
 **/
@Controller
public class BasketController {

    @Autowired
    IStoreRepository storeRepository;

    @Resource
    SessionObject sessionObject;

    @GetMapping("/basket")
    public String basket(Model model){
        model.addAttribute("products", this.sessionObject.getBasked());
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        double sum = 0;
        for (Product product :
                this.sessionObject.getBasked()) {
            sum = sum + product.getPrice()* product.getAmount();
        }
        model.addAttribute("total", sum);
        return "basket";
    }

    @GetMapping("/addToBasket/{codeEAN}")
    public String addToBasket(@PathVariable String codeEAN){
        Product product = this.storeRepository.getProductByCodeEAN(codeEAN);
        this.sessionObject.addToBasked(product.clone());
        return "redirect:/main";
    }
}
