package com.company.doc_lift.controllers;

import com.company.doc_lift.domian.Document;
import com.company.doc_lift.domian.User;
import com.company.doc_lift.repos.DocumentRepo;
import javafx.stage.FileChooser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.IOException;
import java.util.Map;


@Controller
@RequestMapping("/menu")
public class menuController {

    @GetMapping()
    public String main(
            @AuthenticationPrincipal User user,
            Map<String, Object> model) throws IOException {

        model.put("user", user);

        return "menu";
    }
}
