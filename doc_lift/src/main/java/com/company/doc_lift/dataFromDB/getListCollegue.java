package com.company.doc_lift.dataFromDB;

import com.company.doc_lift.domian.Collegues;
import com.company.doc_lift.repos.ColleguesRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class getListCollegue {

    @Autowired
    private ColleguesRepo colleguesRepo;

    public Set<Optional<Collegues>> getColleguesById(List<String> list_id){
        Set<Optional<Collegues>> result = null;
        for (int  key = 0; key < list_id.size(); key++){
            Optional<Collegues> col = colleguesRepo.findById(Long.valueOf(list_id.get(key)));
            result.add(col);
        }
        return result;

    }
}
