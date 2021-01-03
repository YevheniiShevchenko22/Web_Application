package pl.edu.wszib.iphonestore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.edu.wszib.iphonestore.model.Product;
import pl.edu.wszib.iphonestore.model.User;
import pl.edu.wszib.iphonestore.service.IStoreService;
import pl.edu.wszib.iphonestore.session.SessionObject;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by Yevhenii Shevchenko at ${DATE}
 * Project name: ${PROJECT_NAME}
 **/
@Controller
public class AdminController {

    @Autowired
    IStoreService storeService;

    @Resource
    SessionObject sessionObject;

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model){
        if (!this.sessionObject.isLogged() || User.Role.valueOf(this.sessionObject.getLoggedUser().getRole()) != User.Role.ADMIN){
            return "redirect:/login";
        }

        //Product product = this.storeRepository.getProductByCodeEAN(codEAN);
        Product product = this.storeService.getProductById(id);

        model.addAttribute("product", product);
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        model.addAttribute("role", this.sessionObject.isLogged() ? this.sessionObject.getLoggedUser().getRole().toString() : null);

        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@ModelAttribute Product product){
        if (!this.sessionObject.isLogged() || User.Role.valueOf(this.sessionObject.getLoggedUser().getRole()) != User.Role.ADMIN){
            return "redirect:/login";
        }

        this.storeService.updateProduct(product);

        return "redirect:/main";
    }

    @GetMapping("/add")
    public String newProduct(Model model){
        if (!this.sessionObject.isLogged() || User.Role.valueOf(this.sessionObject.getLoggedUser().getRole()) != User.Role.ADMIN){
            return "redirect:/login";
        }
        model.addAttribute("newProduct", new Product());
        model.addAttribute("role", this.sessionObject.isLogged() ? this.sessionObject.getLoggedUser().getRole().toString() : null);

        return "add";
    }

    @PostMapping("/add")
    public String saveProduct(@ModelAttribute(name="productCreate") Product product,
                           @RequestParam("image") MultipartFile multipartFile) throws IOException {

        if (!this.sessionObject.isLogged() || User.Role.valueOf(this.sessionObject.getLoggedUser().getRole()) != User.Role.ADMIN){
            return "redirect:/login";
        }

        this.storeService.saveProduct(product, multipartFile);

        return "redirect:/main";
    }
}
