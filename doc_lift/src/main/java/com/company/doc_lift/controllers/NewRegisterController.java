package com.company.doc_lift.controllers;


import com.company.doc_lift.domian.Collegues;
import com.company.doc_lift.domian.Document;
import com.company.doc_lift.domian.Register;
import com.company.doc_lift.domian.User;
import com.company.doc_lift.repos.ColleguesRepo;
import com.company.doc_lift.repos.DocumentRepo;
import com.company.doc_lift.repos.RegisterRepo;
import com.company.doc_lift.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.UUID;


@Controller
@RequestMapping("/newRegister")
public class NewRegisterController {

    @Autowired
    private DocumentRepo documentRepo;

    @Autowired
    private ColleguesRepo colleguesRepo;

    @Autowired
    private RegisterRepo registerRepo;


    @Autowired
    private mailSender mailSender;


    @Value("${upload.path}")
    private String uploadPath;

    @Value("${upload.path.document}")
    private String uploadPathDocument;




    @GetMapping()
    public String newR(Model model){
        Iterable<Collegues> collegues = colleguesRepo.findAll();
        model.addAttribute("collegues", collegues);
        return "newRegister";
    }



    @PostMapping()
    public String newReg(
            @RequestParam Map<String,String> form,
            @AuthenticationPrincipal User user,
            @RequestParam("file") MultipartFile file,
            Model model
    ) throws IOException, MessagingException {
        tightenDocument tightenDocument = new tightenDocument();
        uploadDocumentImg uploadDocumentImg = new uploadDocumentImg();
        getListCollegue getListCollegue = new getListCollegue();
        saveCollegues saveCollegues = new saveCollegues();
        dateController dateController = new dateController();

        if (form.get("doc_id") == null){
            model.addAttribute("message", "ERROR!!!!! You have fill in column `id`");
            return "redirect:/newRegister";
        }

        Iterable<Document> doc = documentRepo.findAllByDocid(Integer.parseInt(form.get("doc_id")));
        int sput = 0;
        for (Document docum : doc){
            sput++;
        }
        if ( sput == 0){
            Document document_new = new Document();
            document_new.setDocid(Integer.parseInt(form.get("doc_id")));
            documentRepo.save(document_new);
            tightenDocument.runFireBird();
        }
        Document document = documentRepo.findFirstByDocid(Integer.parseInt(form.get("doc_id")));

        if (document.getData() == null){
            model.addAttribute("message", "ERROR!!!!! no document with this id was found");
            return "redirect:/newRegister";
        }

        if (!file.getOriginalFilename().equals("")){
            File uploadDir = new File(uploadPath);

            if(!uploadDir.exists()){
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFileName));
            document.setImg(resultFileName);
            documentRepo.save(document);
        }
        int count_key = 0;
        Set<String> allkey = form.keySet();
        for (String key : allkey){
            if(key.indexOf("col") > -1){
                count_key++;
            }
        }
        String[] nedkey = new String[count_key];
        count_key = 0;
        for (String key : allkey){
            if(key.indexOf("col") > -1){
                nedkey[count_key] = key;
                count_key++;
            }
        }
        Long[] allid = new Long[count_key];
        int i = 0;
        for(String key : nedkey){
            allid[i] = Long.valueOf(form.get(key));
            i++;
        }

        Set<Collegues> collegues = (Set<Collegues>) colleguesRepo.findAllByIdIsIn(allid);

        if (collegues.size() == 0){
            model.addAttribute("message", "ERROR!!!!! You have to choice any collegues");
            return "redirect:/newRegister";
        }
        String date = dateController.dateToday();


        Register register = new Register();
        register.setColl(collegues);
        register.setDoc(document);
        register.setAuthor(user);
        register.setComment(form.get("comment"));
        register.setStart(date);
        registerRepo.save(register);

        String filePath = uploadPathDocument + "\\" + document.getData().substring(0,4) + "\\" + document.getData().substring(5,7) + "\\" + document.getData().substring(8,10) + "\\" + document.getName();
        String imgPath = uploadPath + "/" + document.getImg();
        mailSender.send("bodnazhevska.b99@gmail.com", "Document Lift", "Cool job", filePath, document.getName(), imgPath, document.getImg());

        return "menu";

    }


}
