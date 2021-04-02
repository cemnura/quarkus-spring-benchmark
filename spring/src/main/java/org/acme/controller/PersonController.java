package org.acme.controller;

import org.acme.entity.Person;
import org.acme.exception.NotFoundException;
import org.acme.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persons")
public class PersonController {

    @Autowired
    private PersonRepository repository;

    @PostMapping
    public void create(@RequestBody Person person) {
        repository.save(person);
    }

    @GetMapping("/{id}")
    public Person getById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }
}
