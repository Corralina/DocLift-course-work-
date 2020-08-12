package com.company.doc_lift.domian;

import org.springframework.security.core.GrantedAuthority;

public enum  Role implements GrantedAuthority {
    USER, ADMIN, REG;

    @Override
    public String getAuthority() {
        return name();
    }
}
