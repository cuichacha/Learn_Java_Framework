package code2.exception;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(BusinessException.class)
    public String handleBusinessException(BusinessException businessException, Model model) {
        model.addAttribute("message", businessException.getMessage());
        return "Error";
    }
}
