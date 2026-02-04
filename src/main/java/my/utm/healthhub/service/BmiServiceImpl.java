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

        Person p1 = new Person();
        p1.setName("Ali");
        p1.setHeight(1.70);
        p1.setWeight(65);
        p1.setYob(2000); // boleh dummy
        list.add(p1);

        Person p2 = new Person();
        p2.setName("Siti");
        p2.setHeight(1.60);
        p2.setWeight(55);
        p2.setYob(2001); // boleh dummy
        list.add(p2);

        return list;
    }
}
