package com.demo.neo4j.controller;

import com.demo.neo4j.entity.PersonRelationship;
import com.demo.neo4j.repository.PersonRelationshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping("relationship")
public class PersonRelationshipController {

    @Autowired
    private PersonRelationshipRepository relationshipRepo;

    @GetMapping("{id}")
    @ResponseBody
    public PersonRelationship getById(@PathVariable("id") Long id) {
        Optional<PersonRelationship> person = relationshipRepo.findById(id);
        return person.orElse(null);
    }

}
