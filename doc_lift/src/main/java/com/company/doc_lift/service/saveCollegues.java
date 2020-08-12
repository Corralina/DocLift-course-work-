package com.company.doc_lift.service;

import com.company.doc_lift.domian.Collegues;
import com.company.doc_lift.domian.Document;
import com.company.doc_lift.domian.Register;
import com.company.doc_lift.domian.User;
import com.company.doc_lift.repos.RegisterRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class saveCollegues {

    @Autowired
    private RegisterRepo registerRepo;

    public void save(Set<Collegues> collegues, Document document, User author, String coment, String data){
        Register register = new Register();
        register.setColl(collegues);
        register.setDoc(document);
        register.setAuthor(author);
        register.setComment(coment);
        register.setStart(data);
        registerRepo.save(register);

    }
}
