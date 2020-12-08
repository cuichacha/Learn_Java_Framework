package code.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(BusinessException.class)
    public String handleBusinessException(BusinessException businessException, Model model) {
        model.addAttribute("message", businessException.getMessage());
        return "Error";
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public String handleBusinessException(Exception exception, Model model) {
        model.addAttribute("message", exception.getMessage());
        return "Error";
    }
}
