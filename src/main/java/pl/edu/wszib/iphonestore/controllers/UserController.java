package pl.edu.wszib.iphonestore.controllers;

import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.iphonestore.database.IUserRepository;
import pl.edu.wszib.iphonestore.model.Role;
import pl.edu.wszib.iphonestore.model.User;
import pl.edu.wszib.iphonestore.model.view.RegisterModel;
import pl.edu.wszib.iphonestore.session.SessionObject;

import javax.annotation.Resource;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerForm( Model model)
    {
        model.addAttribute("registerModel", new RegisterModel());
        model.addAttribute("info", this.sessionObject.getInfo());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute RegisterModel registerModel ){
        Pattern regex = Pattern.compile("[A-Za-z0-9]{5}.*");
        Matcher validateLogin = regex.matcher(registerModel.getLogin());
        Matcher validatePass = regex.matcher(registerModel.getPass());
        Matcher validatePass2 = regex.matcher(registerModel.getPass2());

        if (!validateLogin.matches() || !validatePass.matches() || !validatePass2.matches() || !registerModel.getPass().equals(registerModel.getPass2())){
            this.sessionObject.setInfo("Validation ERROR!");
            return "redirect:/register";
        }

        boolean registerResult = userRepository.register(registerModel.toUser(registerModel));

        if (registerResult){
            return "redirect:/login";
        }else{
            this.sessionObject.setInfo("Login is occuped!");
            return "redirect:/register";
        }
    }
}
