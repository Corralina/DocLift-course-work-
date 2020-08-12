package com.company.service;

public class getUserDomen {
    public String getDomen(){
        return new com.sun.security.auth.module.NTSystem().getName();
    }
}
