package ru.maxima.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.maxima.dao.PersonDao;
import ru.maxima.model.Person;

import java.util.List;

// localhost:8080/people

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDao personDao;

    @Autowired
    public PeopleController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping
    public String getAllPeople(Model model) {

        List<Person> allPeople = personDao.getAllPeople();
        model.addAttribute("allPeople", allPeople);

        return "view-with-all-people";
    }
}
