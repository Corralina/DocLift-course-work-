package com.company.doc_lift.controllers;


import com.company.doc_lift.domian.Role;
import com.company.doc_lift.domian.User;
import com.company.doc_lift.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class createUserController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model){
        User userFronDB = userRepo.findByUsername(user.getUsername());
        if (userFronDB != null){
            model.put("message", user.getUsername());
            return "registration";
        }

        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
        return "redirect:/login";

    }
}
