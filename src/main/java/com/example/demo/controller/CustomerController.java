package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static org.springframework.hateoas.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by song on 2017/11/1.
 */
//扩展API
// a custom handler for a specific resource
// return HATEOAS style json
@RepositoryRestController
public class CustomerController {
    @Autowired
    private PersonRepository personRepository;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/persons/search/listPerson")
    public ResponseEntity<?> getPersons() {
        List<Person> persons = (List<Person>) personRepository.findAll();
        Resources<Person> resources = new Resources<Person>(persons);
        resources.add(linkTo(methodOn(CustomerController.class).getPersons()).withSelfRel());
        // add other links as needed
        return ResponseEntity.ok(resources);
    }

}