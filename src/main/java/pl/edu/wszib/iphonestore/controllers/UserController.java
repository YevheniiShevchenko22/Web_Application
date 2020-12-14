package pl.edu.wszib.iphonestore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.wszib.iphonestore.database.IUserRepository;
import pl.edu.wszib.iphonestore.model.Role;
import pl.edu.wszib.iphonestore.model.User;

/**
 * Created by Yevhenii Shevchenko at 12/14/20
 * Project name: iphonestore
 **/
@Controller
public class UserController {

    @Autowired
    IUserRepository userRepository;

    @GetMapping("/login")
    public String loginform(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String login,
                        @RequestParam String pass){
        User user = new User(1, login, pass, Role.USER);
        boolean authResult = this.userRepository.authenticate(user);
        if (authResult){
            return "redirect:/main";
        }else{
            return "login";
        }
    }
}
