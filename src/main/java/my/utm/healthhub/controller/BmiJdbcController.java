package my.utm.healthhub.controller;

import my.utm.healthhub.jdbcdao.BmiRecordDao;
import my.utm.healthhub.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BmiJdbcController {

    @Autowired
    private BmiRecordDao bmiRecordDao;

    @GetMapping("/bmi/jdbc/list")
    public String listJdbcRecords(Model model) {
        List<Person> records = bmiRecordDao.findAll();
        model.addAttribute("records", records);
        return "bmi_list_db";
    }

    @GetMapping("/bmi/jdbc/add")
    public String showJdbcForm(Model model) {
        model.addAttribute("person", new Person());
        return "bmi_form_db";
    }

    @PostMapping("/bmi/jdbc/add")
    public String submitJdbcForm(@ModelAttribute("person") Person person) {

        // 1️⃣ calculate BMI
        double bmi = person.getWeight() /
                (person.getHeight() * person.getHeight());
        person.setBmi(bmi);

        // 2️⃣ determine BMI category
        String category;
        if (bmi < 18.5) {
            category = "Underweight";
        } else if (bmi < 25) {
            category = "Normal";
        } else if (bmi < 30) {
            category = "Overweight";
        } else {
            category = "Obese";
        }
        person.setCategory(category);

        // 3️⃣ save to database
        bmiRecordDao.save(person);

        return "redirect:/bmi/jdbc/list";
    }
}
