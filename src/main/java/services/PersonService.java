package services;

import models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.PersonRepository;

public class PersonService {
    @Autowired
    PersonRepository repository;
    public PersonService(PersonRepository repository) {this.repository = repository;}

    public Iterable<Person> index(){return repository.findAll();}

    public Person show(Long id) {return repository.findOne(id);}

    public Person create(Person p){return repository.save(p);}

    public Person update(Long id, Person newPersonData){
        Person original = repository.findOne(id);
        original.setFirstName(newPersonData.getFirstName());
        original.setLastName(newPersonData.getLastName());
        return repository.save(original);
    }

    public Boolean delete(Long id){
        repository.delete(id);
        return true;
    }
}
