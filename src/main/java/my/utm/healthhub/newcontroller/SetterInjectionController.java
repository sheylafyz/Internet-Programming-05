package my.utm.healthhub.newcontroller;

import my.utm.healthhub.newservice.NewBmiServiceSetterImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SetterInjectionController {

    private NewBmiServiceSetterImpl setterBmiService;

    @Autowired
    public void setSetterBmiService(NewBmiServiceSetterImpl setterBmiService) {
        this.setterBmiService = setterBmiService;
    }

    @GetMapping("/bmi-setter")
    public String showBmiSetter(Model model) {
        model.addAttribute("records", setterBmiService.getNewBmiRecords());
        return "bmi_list";
    }
}
