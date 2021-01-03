package pl.edu.wszib.iphonestore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.iphonestore.service.IStoreService;
import pl.edu.wszib.iphonestore.session.SessionObject;

import javax.annotation.Resource;
/**
 * Created by Yevhenii Shevchenko at 12/9/20
 * Project name: iphonestore
 **/

@Controller
public class RunController {

    @Autowired
    IStoreService storeService;

    @Resource
    SessionObject sessionObject;

    @GetMapping("/")
    public String landingPage(){
        return "redirect:main";
    }

    @GetMapping("/main")
    public String main(Model model){

        model.addAttribute("products", this.storeService.getAllProducts());
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        model.addAttribute("role", this.sessionObject.isLogged() ? this.sessionObject.getLoggedUser().getRole().toString() : null);

        return "main";
    }

    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        return "about";
    }

    @GetMapping("/contact")
    public String contact(Model model){
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        return "contact";
    }

}
