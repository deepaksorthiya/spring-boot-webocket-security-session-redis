package com.example.mvc;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;


@ControllerAdvice
public class UserControllerAdvise {

    @ModelAttribute("currentUserName")
    String currentUser(Principal principal) {
        return (principal != null) ? principal.getName() : null;
    }

}
