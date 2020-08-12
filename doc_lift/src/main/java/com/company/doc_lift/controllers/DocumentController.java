package com.company.doc_lift.controllers;

import com.company.doc_lift.domian.Collegues;
import com.company.doc_lift.domian.Document;
import com.company.doc_lift.domian.Register;
import com.company.doc_lift.repos.ColleguesRepo;
import com.company.doc_lift.repos.DocumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/documents")
public class DocumentController {

    @Autowired
    private DocumentRepo documentRepo;

    @Autowired
    private ColleguesRepo colleguesRepo;


    @GetMapping()
    public String show(
            Map<String, Object> model
    ){
        Iterable<Document> documents = documentRepo.findAll();

        model.put("documents", documents);

        return "documents";
    }


    @GetMapping("{document}")
    public String addRegister(
            @PathVariable Document document,
            Model model
    ){

        Iterable<Collegues> collegues = colleguesRepo.findAll();

        model.addAttribute("document", document);
        model.addAttribute("collegues",collegues);

        return"addRegister";
    }
}
