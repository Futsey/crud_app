package crud_app.dao;

import crud_app.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Oleg", 14, "Oleg@mail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Andrew", 41, "Andrew@mail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Anton", 24, "Anton@mail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Tom", 37, "Tom@mail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Jerry", 29, "Jerry@mail.com"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream()
                .filter(person -> person.getId() == id)
                .findAny()
                .orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }


    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
