package com.company.doc_lift.service;

import com.company.doc_lift.domian.Collegues;
import com.company.doc_lift.repos.ColleguesRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.Set;

public class getListCollegue {

    @Autowired
    private ColleguesRepo colleguesRepo;

    public Set<Collegues> getList(Map<String,String> form){
        Set<String> allkey = form.keySet();
        Set<String> nedkey = null;
        for (String key : allkey){
            if(key.indexOf("col") > -1){
                nedkey.add(key);
            }
        }
        Long[] allid = new Long[nedkey.size()];
        int i = 0;
        for(String key : nedkey){
            allid[i] = Long.valueOf(form.get(key));
            i++;
        }

        return (Set<Collegues>) colleguesRepo.findAllByIdIsIn(allid);
    }
}
