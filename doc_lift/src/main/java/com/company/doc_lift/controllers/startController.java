package com.company.doc_lift.controllers;


import com.company.doc_lift.domian.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/")
public class startController {

    @GetMapping()
    public String start(@AuthenticationPrincipal User user,
                        Map<String, Object> model
    ){

        model.put("user", user);

        return "menu";
    }
}
