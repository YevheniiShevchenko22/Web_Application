package pl.edu.wszib.iphonestore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.edu.wszib.iphonestore.service.IBasketService;
import pl.edu.wszib.iphonestore.session.SessionObject;

import javax.annotation.Resource;

/**
 * Created by Yevhenii Shevchenko at 12/21/20
 * Project name: iphonestore
 **/
@Controller
public class BasketController {

    @Autowired
    IBasketService basketService;

    @Resource
    SessionObject sessionObject;

    @GetMapping("/basket")
    public String basket(Model model){
        if (!this.sessionObject.isLogged()){
            return "redirect:/login";
        }

        model.addAttribute("products", this.sessionObject.getBasked());
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        model.addAttribute("total", this.basketService.calculateTotal());

        return "basket";
    }

    @GetMapping("/addToBasket/{id}")
    public String addToBasket(@PathVariable int id){

        if (!this.sessionObject.isLogged()){
            return "redirect:/login";
        }

        this.basketService.addBookByIdToBasket(id);

        return "redirect:/main";
    }
}
