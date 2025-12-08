package com.secj3303.controller;

import com.secj3303.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/bmi")
    public String bmi(Model model) {
        Person person = new Person("Ali", 2001, 65, 1.70);
        model.addAttribute("person", person);
        return "bmi";
    }

    @RequestMapping("/bmi/result")
    public String bmiResult(Model model) {

        String name = "Ali";
        int age = 23;

        double bmiValue = 65 / (1.7 * 1.7);
        String bmiCategory =
                (bmiValue < 18.5) ? "Underweight" :
                (bmiValue < 25) ? "Normal" :
                "Overweight";

        model.addAttribute("name", name);
        model.addAttribute("age", age);
        model.addAttribute("bmiValue", bmiValue);
        model.addAttribute("bmiCategory", bmiCategory);

        return "bmi_result";
    }

    @RequestMapping("/profile")
    public String profile(Model model) {

        Person profile = new Person();
        profile.setFullName("Ali Ahmad");
        profile.setEmail("ali@student.utm.my");
        profile.setHeight(1.70);
        profile.setWeight(65);

        model.addAttribute("profile", profile);

        return "profile";
    }

        @RequestMapping("/bmi/form")
    public String bmiForm() {
        return "bmi_form";
    }

    @RequestMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
}
