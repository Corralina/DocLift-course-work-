package com.company.doc_lift.service;

import com.company.doc_lift.domian.Document;
import com.company.doc_lift.domian.Register;
import com.company.doc_lift.repos.DocumentRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class tightenDocument {

    @Autowired
    private DocumentRepo documentRepo;

    public Document tigController(String doc_id) throws IOException {
        Iterable<Document> doc = documentRepo.findAll();
        int sput = 0;
        for (Document docum : doc){
            sput++;
        }
        if ( sput == 0){
            newDoc(doc_id);
            runFireBird();
        }
//        Document document = documentRepo.findFirstByDocid(Integer.parseInt(doc_id));
        Document document = new Document();
        return document;
    }

    public void newDoc(String doc_id){
        Document document = new Document();
        document.setDocid(Integer.parseInt(doc_id));
        documentRepo.save(document);
    }

    public void runFireBird() throws IOException {
        Process runtime = Runtime.getRuntime().exec("cmd /c java -jar C:\\programm\\update_doc_lift\\out\\artifacts\\update_doc_lift_jar\\update_doc_lift.jar");
    }
}
