package com.example.thymeleaf;

import com.example.thymeleaf.mdel.User;
import com.example.thymeleaf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestControler {

@Autowired
    UserService userService;

    @GetMapping("/listUsers")
    public String test(Model model){

        model.addAttribute("users",userService.listUSer());
                return "list-users-view";
    }
    @GetMapping("/addUser")
    public String addUser(Model model){
        model.addAttribute("user", new User());
        return"add-user";
    }
    @PostMapping("/addUser")
    public String createUser(@ModelAttribute User user, Model model){
        userService.createUser(user.getImie(),user.getNazwisko(),user.getWiek());
        return "redirect:/listUsers";
    }
}












//        users.add(new User(15,"Tralala","blble",66));
//        users.add(new User(14,"Tralalsdga","nvvcvcbe",246));
//        users.add(new User(135,"sdfla","blsewrtle",256));
//        users.add(new User(1556,"Tralala","blble",256));
//        users.add(new User(15346,"Tralala","blbrtle",56));
//        users.add(new User(125,"Tralala","blbssle",65));
