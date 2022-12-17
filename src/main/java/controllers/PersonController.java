package controllers;

import models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repositories.PersonRepository;
import services.PersonService;

import java.util.List;


@RestController
@RequestMapping (value = "/people")
public class PersonController {

    @Autowired
    PersonService service;

    @RequestMapping (method = RequestMethod.POST, value = "/people")
    public ResponseEntity<Person> createPerson(@RequestBody Person p){
        return new ResponseEntity<>(service.create(p), HttpStatus.CREATED);
    }

    @RequestMapping (method =  RequestMethod.GET, value = "/people/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id){
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }
    @RequestMapping (method = RequestMethod.GET, value = "/people")
    public ResponseEntity<Iterable<Person>> getPersonList(){
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }
    @RequestMapping (method = RequestMethod.PUT, value = "/people/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Person p, @RequestBody Long id){
        return new ResponseEntity<>(service.update(id,p), HttpStatus.OK);
    }
    @RequestMapping (method = RequestMethod.DELETE, value = "/people/{id}")
    public ResponseEntity<Boolean> deletePerson (@PathVariable Long id){
       return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
