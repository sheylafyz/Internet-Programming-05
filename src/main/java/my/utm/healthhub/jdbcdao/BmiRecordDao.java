package my.utm.healthhub.jdbcdao;

import my.utm.healthhub.model.Person;
import java.util.List;

public interface BmiRecordDao {
    List<Person> findAll();
    void save(Person person);
    void deleteById(int id);
}
