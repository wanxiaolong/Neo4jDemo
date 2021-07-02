package com.demo.neo4j.controller;

import com.demo.neo4j.entity.Person;
import com.demo.neo4j.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("person")
public class PersonController {

    @Autowired
    private PersonRepository personRepo;

    @GetMapping("{id}")
    @ResponseBody
    public Person getById(@PathVariable("id") Long id) {
        Optional<Person> person = personRepo.findById(id);
        return person.orElse(null);
    }

    @GetMapping("/fof/{name}")
    @ResponseBody
    public List<Person> findFoF(@PathVariable("name") String name) {
        return personRepo.findFriendsOfFriends(name);
    }

    @GetMapping("/ta/{name}")
    @ResponseBody
    public Person findTA(@PathVariable("name") String name) {
        return personRepo.findTA(name);
    }
}
