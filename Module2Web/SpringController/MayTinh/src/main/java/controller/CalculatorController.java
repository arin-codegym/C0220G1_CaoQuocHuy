package controller;

import model.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class CalculatorController {
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getStart() {
        return "cal";
    }

    @RequestMapping(value = "/cal", method = RequestMethod.POST)
    public String getCal(@RequestParam("first-operand") float firstOperand, @RequestParam("second-operand") float secondOperand, @RequestParam("operator") char operator, Model model) {
        String message;
        try {
            float result = Calculator.calculate(firstOperand, secondOperand, operator);
            model.addAttribute("res", result);
        } catch (RuntimeException ex) {
            message = ex.getMessage();
            model.addAttribute("message", message);
        }
        return "cal";
    }
}
