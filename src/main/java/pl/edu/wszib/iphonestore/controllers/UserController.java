package pl.edu.wszib.iphonestore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.wszib.iphonestore.database.IUserRepository;
import pl.edu.wszib.iphonestore.model.Role;
import pl.edu.wszib.iphonestore.model.User;
import pl.edu.wszib.iphonestore.session.SessionObject;

import javax.annotation.Resource;

/**
 * Created by Yevhenii Shevchenko at 12/14/20
 * Project name: iphonestore
 **/
@Controller
public class UserController {

    @Autowired
    IUserRepository userRepository;

    @Resource
    SessionObject sessionObject;

    @GetMapping("/login")
    public String loginform(Model model){
        if (this.sessionObject.isLogged()){
            return "redirect:/main";
        }
        model.addAttribute("userModel", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user){
        this.sessionObject.setLoggedUser(this.userRepository.authenticate(user));
        if (this.sessionObject.isLogged()){
            return "redirect:/main";
        }else{
            return "redirect:/login";
        }
    }

    @GetMapping("/logout")
    public String logout(){
        this.sessionObject.setLoggedUser(null);
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String registerForm()
    {
        return "register";
    }
}
