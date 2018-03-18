package es.fiturjc.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.view.RedirectView;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(UserNotFullException.class)
    public RedirectView handleUserProfileIsNotFull(UserNotFullException e){
        return new RedirectView("/user/editUser");
    }
}
