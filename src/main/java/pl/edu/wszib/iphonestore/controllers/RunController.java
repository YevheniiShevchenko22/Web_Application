package pl.edu.wszib.iphonestore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.edu.wszib.iphonestore.database.IStoreRepository;
import pl.edu.wszib.iphonestore.model.Product;
import pl.edu.wszib.iphonestore.session.SessionObject;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Yevhenii Shevchenko at 12/9/20
 * Project name: iphonestore
 **/

@Controller
public class RunController {

    @Autowired
    IStoreRepository storeRepository;

    @Resource
    SessionObject sessionObject;

    @GetMapping("/")
    public String landingPage(){
        return "redirect:main";
    }

    @GetMapping("/main")
    public String main(Model model){
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        return "main";
    }

    @GetMapping("/product")
    public String product(Model model){
        List<Product> products = this.storeRepository.getAllProduct();
        model.addAttribute("products", products);
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        return "product";
    }

    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        return "about";
    }

    @GetMapping("/store")
    public String store(Model model){
        List<Product> products = this.storeRepository.getAllProduct();
        model.addAttribute("products", products);
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        return "store";
    }

    @GetMapping("/contact")
    public String contact(Model model){
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        return "contact";
    }

    /*@PostMapping("/products/show")
    public String show(@ModelAttribute Product product,
                       RedirectAttributes ra,
                       @RequestParam("fileImage")MultipartFile multipartFile) throws IOException{
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        product.setPic(fileName);

        return "redirect:product";
    }*/

}
