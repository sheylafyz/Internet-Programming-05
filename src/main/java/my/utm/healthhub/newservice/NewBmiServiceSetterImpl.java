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
        records.add(new Person("Ali", 1.70, 65));
        records.add(new Person("Siti", 1.60, 55));
        records.add(new Person("Farah", 1.55, 50));
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
