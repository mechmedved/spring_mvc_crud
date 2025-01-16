package ru.maxima.dao;

import org.springframework.stereotype.Component;
import ru.maxima.model.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDao {

    private static Long NEXT_ID = 0L;

    private List<Person> allPeople;
    {
        allPeople = new ArrayList<>();
        allPeople.add(new Person(++NEXT_ID,"Alex",25,"Alex@email"));
        allPeople.add(new Person(++NEXT_ID,"Nicolay",33,"Nicolay@email"));
        allPeople.add(new Person(++NEXT_ID,"George",27,"George@email"));
        allPeople.add(new Person(++NEXT_ID,"Rafael",29,"Rafael@email"));
        allPeople.add(new Person(++NEXT_ID,"Viktor",41,"Victor@email"));
    }

    public List<Person> getAllPeople() {
        return allPeople;
    }

    public Person getAllPeopleById(Long id) {

        return allPeople.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    public void savePerson(Person person) {
        person.setId(++NEXT_ID);
        allPeople.add(person);
    }

    public void update(Person personFromForm, Long id) {
        Person person = getAllPeopleById(id);
        person.setName(personFromForm.getName());
        person.setAge(personFromForm.getAge());
        person.setEmail(personFromForm.getEmail());
    }

    public void delete(Long id) {
        allPeople.removeIf(person -> person.getId().equals(id));
    }
}
