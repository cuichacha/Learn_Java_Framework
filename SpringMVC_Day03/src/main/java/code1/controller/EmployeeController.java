package code1.controller;

import code1.controller.groups.GroupA;
import code1.domain.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class EmployeeController {
    @RequestMapping("/AddEmployee")
    public String employeeValidator(@Validated(GroupA.class) Employee employee, Errors errors, Model model) {
        if (errors.hasErrors()) {
            List<FieldError> fieldErrors = errors.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                String field = fieldError.getField();
                System.out.println(field);
                String defaultMessage = fieldError.getDefaultMessage();
                System.out.println(defaultMessage);
                model.addAttribute(field, defaultMessage);
            }
            return "AddEmployee";
        }
        return "Success";
    }
}
