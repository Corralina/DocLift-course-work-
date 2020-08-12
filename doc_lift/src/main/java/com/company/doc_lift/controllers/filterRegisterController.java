package com.company.doc_lift.controllers;


import com.company.doc_lift.domian.Collegues;
import com.company.doc_lift.domian.Document;
import com.company.doc_lift.domian.Register;
import com.company.doc_lift.domian.User;
import com.company.doc_lift.repos.ColleguesRepo;
import com.company.doc_lift.repos.DocumentRepo;
import com.company.doc_lift.repos.RegisterRepo;
import com.company.doc_lift.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class filterRegisterController {

    @Autowired
    RegisterRepo registerRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    DocumentRepo documentRepo;

    @Autowired
    ColleguesRepo colleguesRepo;

    @PostMapping("/filterAuthor")
    public String filterAuthor(
            @RequestParam Map<String,String> form,
            Model model
    ){

        User author = userRepo.findByUsername(form.get("filter"));

        Iterable<Register> registers = registerRepo.findAllByAuthor(author);

        model.addAttribute("registers", registers);

        return "registers";
    }

    @PostMapping("/filterNumber")
    public String filterNumber(
            @RequestParam Map<String,String> form,
            Model model
    ) {

        Iterable<Document> documents = documentRepo.findAllByNumberLike("%" + form.get("filter") + "%");

        Iterable<Register> registers = registerRepo.findAllByDocIn(documents);

        model.addAttribute("registers", registers);

        return "registers";
    }

    @PostMapping("/filterCollegues")
    public String filterCollegue(
            @RequestParam Map<String,String> form,
            Model model
    ) {

        Iterable<Collegues> collegues = colleguesRepo.findAllByNameLike("%" + form.get("filter") + "%");

        Iterable<Register> registers = registerRepo.findAllByCollIn(collegues);

        model.addAttribute("registers", registers);

        return "registers";
    }
}
