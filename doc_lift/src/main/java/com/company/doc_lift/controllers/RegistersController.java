package com.company.doc_lift.controllers;


import com.company.doc_lift.domian.Register;
import com.company.doc_lift.repos.RegisterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping("/registers")
public class RegistersController {
    @Autowired
    private RegisterRepo registerRepo;

    @GetMapping()
    public String registers(Model model){

        Iterable<Register> registers = registerRepo.findAll();
        model.addAttribute("registers", registers);

        return "registers";
    }
}
