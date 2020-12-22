package pl.edu.wszib.iphonestore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Yevhenii Shevchenko at ${DATE}
 * Project name: ${PROJECT_NAME}
 **/
@Controller
public class AdminController {

    @GetMapping("/edit/{kodEAN}")
    public String editForm(@PathVariable String kodEAN){
        //TODO
        return "??";
    }
}
