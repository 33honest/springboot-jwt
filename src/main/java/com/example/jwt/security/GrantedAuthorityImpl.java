package com.example.jwt.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Nathan.Liu on 2020/5/11.
 */
public class GrantedAuthorityImpl implements GrantedAuthority {

    private String authority;

    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

}
