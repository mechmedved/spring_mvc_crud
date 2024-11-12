package ru.maxima.dao;

import org.springframework.stereotype.Component;
import ru.maxima.model.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDao {

    private List<Person> allPeople;
    {
        allPeople = new ArrayList<>();
        allPeople.add(new Person(1L,"Alex"));
        allPeople.add(new Person(2L,"Nicolay"));
        allPeople.add(new Person(3L,"George"));
        allPeople.add(new Person(4L,"Rafael"));
        allPeople.add(new Person(5L,"Viktor"));
    }

    public List<Person> getAllPeople() {
        return allPeople;
    }
}
