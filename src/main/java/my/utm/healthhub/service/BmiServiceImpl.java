package my.utm.healthhub.service;

import my.utm.healthhub.model.Person;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BmiServiceImpl implements BmiService {

    @Override
    public List<Person> getSampleBmiRecords() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Ali", 1.70, 65));
        list.add(new Person("Siti", 1.60, 55));
        return list;
    }
}
