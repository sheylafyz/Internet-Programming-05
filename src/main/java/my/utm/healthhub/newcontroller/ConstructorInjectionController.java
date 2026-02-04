package my.utm.healthhub.newcontroller;

import my.utm.healthhub.newservice.NewBmiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConstructorInjectionController {

    private final NewBmiService constructorBmiService;

    @Autowired
    public ConstructorInjectionController(@Qualifier("newBmiServiceConstructorImpl") NewBmiService constructorBmiService) {
        this.constructorBmiService = constructorBmiService;
    }

    @GetMapping("/bmi-constructor")
    public String showBmiConstructor(Model model) {
        model.addAttribute("records", constructorBmiService.getNewBmiRecords());
        return "bmi_list";
    }
}
