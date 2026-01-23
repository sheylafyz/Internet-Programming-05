package my.utm.healthhub.newservice;

import my.utm.healthhub.model.Person;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class NewBmiServiceConstructorImpl implements NewBmiService {

    private final List<Person> records;

    public NewBmiServiceConstructorImpl() {
        this.records = new ArrayList<>();
        records.add(new Person("Ali", 1.70, 65));
        records.add(new Person("Siti", 1.60, 55));
        records.add(new Person("Farah", 1.55, 50));
    }

    @Override
    public List<Person> getNewBmiRecords() {
        return records;
    }
}
