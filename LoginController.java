package com.example.security;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.SecurityContext;

@Named
@RequestScoped
public class LoginController {

    @Inject
    private SecurityContext securityContext;

    private String username;
    private String password;

    public String doLogin() {
        if (securityContext.authenticate(FacesContext.getCurrentInstance().getExternalContext(), username, password)) {
            return "/secured/home.xhtml?faces-redirect=true";
        } else {
            return "/error.xhtml?faces-redirect=true";
        }
    }

}
