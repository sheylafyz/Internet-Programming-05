package my.utm.healthhub.controller;

import my.utm.healthhub.service.BmiService;
import my.utm.healthhub.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class BmiController {

    @Autowired
    private BmiService bmiService;

    @GetMapping("/bmi-list")
    public String showBmiList(Model model) {
        List<Person> list = bmiService.getSampleBmiRecords();
        model.addAttribute("records", list);
        return "bmi_list";
    }
}
