package my.utm.healthhub.newservice;

import my.utm.healthhub.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewBmiServiceSetterImpl implements NewBmiService {

    private List<Person> records;

    public NewBmiServiceSetterImpl() {
        this.records = new ArrayList<>();

        Person p1 = new Person();
        p1.setName("Ali");
        p1.setHeight(1.70);
        p1.setWeight(65);
        p1.setYob(2000);
        records.add(p1);

        Person p2 = new Person();
        p2.setName("Siti");
        p2.setHeight(1.60);
        p2.setWeight(55);
        p2.setYob(2001);
        records.add(p2);

        Person p3 = new Person();
        p3.setName("Farah");
        p3.setHeight(1.55);
        p3.setWeight(50);
        p3.setYob(2002);
        records.add(p3);
    }

    // setter injection
    public void setRecords(List<Person> records) {
        this.records = records;
    }

    @Override
    public List<Person> getNewBmiRecords() {
        return records;
    }
}
