/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monolith.monolith.controller;

import com.monolith.monolith.model.Belonging;
import com.monolith.monolith.model.Person;
import com.monolith.monolith.repository.BelongingRepository;
import com.monolith.monolith.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */

@RestController //Restful API
@RequestMapping("api/person") // localhost:8088/api/person
public class PersonController {

    @Autowired
    PersonService personService;

    /**
     * - GET    -> getAll() 
     * - GET    -> getById() 
     * - POST    -> save(Person person) 
     * - PUT    -> saveNewLastName(Integer id, String lastName) 
     * - DELETE    -> delete(Integer id)
     * @return 
     */
//    @GetMapping("") 
//    public String personHome(){
//        //personService.dummyData();
//        return "person"; 
//    }
   
    @GetMapping("")
    public List<Person> getAll(){
        return personService.getAllPerson();
    }
    
    @GetMapping("/{id}") //localhost:8088/api/person/1
    public Person getById(@PathVariable Integer id){
        return personService.getById(id);
    }
    
    @PostMapping()
    public Person save(@RequestBody Person person){
        return personService.insert(person);
    }
    
    @PutMapping("/{id}") // Put [..] -> Mudjiarto, Patch Kelana -> Mudjiarto
    public Person save(@PathVariable Integer id,@RequestBody Person person){
        return personService.update(id, person);
    }
//    @PatchMapping("/{id}") // Put [..] -> Mudjiarto, Patch Kelana -> Mudjiarto
//    public Person save(@PathVariable Integer id,@RequestBody Person person){
//        return personService.update(id, person);
//    }
    
    @DeleteMapping("/{id}")
    public Person delete(@PathVariable Integer id){
        return personService.deleteById(id);
    }
    
    @PostMapping("belonging")
    public Person save(@RequestBody Belonging belonging){
//        return personService.insert(person);
       return personService.givePencilAndEraser(belonging);
    }
    
    @PutMapping("belonging/{ids}") // Put [..] -> Mudjiarto, Patch Kelana -> Mudjiarto
    public Belonging saveBelonging(@PathVariable Integer ids,@RequestBody Belonging belonging){
        return personService.update(ids, belonging);
    }
    
    @GetMapping("belonging")
    public List<Belonging> getAllBelonging(){
        return personService.getAllBelonging();
    }
    
    @GetMapping("belonging/{id}") //localhost:8088/api/person/1
    public Belonging getByIdBelong(@PathVariable Integer id){
        return personService.getByIdBelonging(id);
    }
    
    @DeleteMapping("belonging/{id}")
    public Belonging deleteBeloging(@PathVariable Integer id){
        return personService.deleteByIdBelonging(id);
    }
}
