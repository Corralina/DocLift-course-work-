package com.company.doc_lift.parseText;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class parseFormRegist {

    public List<String> parseForm(Map<String,String> form){
        List<String> result = null;
        Set<String> mas_key = form.keySet();
        for (String key : form.keySet()){
            if(key.indexOf("col") > 0){
                 result.add(form.get(key));
            }
        }
        return result;
    }
}
