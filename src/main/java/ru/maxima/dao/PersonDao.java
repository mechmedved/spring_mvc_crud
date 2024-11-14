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
        allPeople.add(new Person(++NEXT_ID,"Alex"));
        allPeople.add(new Person(++NEXT_ID,"Nicolay"));
        allPeople.add(new Person(++NEXT_ID,"George"));
        allPeople.add(new Person(++NEXT_ID,"Rafael"));
        allPeople.add(new Person(++NEXT_ID,"Viktor"));
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
}
