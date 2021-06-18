/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monolith.monolith.service;

import com.monolith.monolith.model.Belonging;
import com.monolith.monolith.model.Person;
import com.monolith.monolith.repository.BelongingRepository;
import com.monolith.monolith.repository.PersonRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author user
 */
@Service
public class PersonService {
    @Autowired //dependency injection 
    PersonRepository personRepository;
    @Autowired
    BelongingRepository belongingRepository;
    
     public Person insert(Person person) {
        if (person.getId() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Data already exists");
        }
        return personRepository.save(person);
    }

    //Read All
    public List<Person> getAllPerson() {
        List<Person> people = personRepository.findAll();
        return people;
    }

    public void dummyData() {
        List<Person> people = new ArrayList<>();

        people.add(new Person("Aqira", "Kelana", "Male"));
        people.add(new Person("Kevin", "Harlim", "Male"));
        people.add(new Person("Lois", "Ceka","Male"));
        people.add(new Person("Artia", "Cristy","Female"));
        personRepository.saveAll(people);
    }

    //Read -> getById(Integer id) -> findById(id)
    public Person getById(Integer id) {
        if (personRepository.existsById(id)) {
            return personRepository.findById(id).get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Data");
    }

    //Update -> update(Integer id) -> 1 Kevin Harlim
    public Person update(Integer id, Person person) {
        Person oldPerson = getById(id);
        oldPerson.setFirstName(person.getFirstName());
        oldPerson.setLastName(person.getLastName());
        oldPerson.setGender(person.getGender());

        return personRepository.save(oldPerson);
    }

    //Delete -> deleteById(Integer id)
    public Person deleteById(Integer id) {
        Person person = getById(id);
        personRepository.delete(person);
        return person;
    }
    
    
    //Belonging
    public List<Belonging> getAllBelonging() {
        List<Belonging> belongings = belongingRepository.findAll();
        return belongings;
    }
    
     //Read -> getById(Integer id) -> findById(id)
    public Belonging getByIdBelonging(Integer id) {
        if (belongingRepository.existsById(id)) {
            return belongingRepository.findById(id).get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Data");
    }
    
    public Belonging deleteByIdBelonging(Integer id) {
        Belonging belonging = getByIdBelonging(id);
        belongingRepository.delete(belonging);
        return belonging;
    }
    
    public Belonging update(Integer ids, Belonging belonging) {
        Belonging oldBelonging = getByIdBelonging(ids);
        oldBelonging.setName(belonging.getName());
        oldBelonging.setQuantity(belonging.getQuantity());
        oldBelonging.setPerson(belonging.getPerson());
        return belongingRepository.save(oldBelonging);
    }
     
//     public Person givePencilAndEraser(Integer id, Integer idBrand){
    public Person givePencilAndEraser(Belonging belonging){
       Person person = getById(belonging.getId());
       List<Belonging> belongings = new ArrayList<>();
       belongings.add(new Belonging(belonging.getName(), belonging.getQuantity(), person));
       List<Belonging> insertedBelongings = belongingRepository.saveAll(belongings); 
       person.setBelongings(insertedBelongings);
       personRepository.save(person);
       return person;

//        Person person = getById(id);
//        Brand brand = getByIdBrand(idBrand);
//        List<Belonging> belongings = new ArrayList<>();
//        belongings.add(new Belonging("Pen", 5, person, brand));
//        belongings.add(new Belonging("Ruler", 2, person, brand));
//        List<Belonging> insertBelongings = belongingRepository.saveAll(belongings);
//        person.setBelongings(insertBelongings);
//        personRepository.save(person);
//        brandRepository.save(brand);
//        return person;
    }
    
}
