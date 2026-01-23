package my.utm.healthhub.newservice;

import my.utm.healthhub.model.Person;
import java.util.List;

public interface NewBmiService {
    List<Person> getNewBmiRecords();
}
