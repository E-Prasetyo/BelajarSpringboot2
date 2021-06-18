/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monolith.monolith.repository;

import com.monolith.monolith.model.Person;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author user
 */
public interface PersonRepository extends JpaRepository<Person, Integer> {
    @Query(nativeQuery = true, 
            value = "SELECT * FROM person WHERE gender = 'FEMALE'")
    public List<Person> findAllFemales();
    
//    @Query(nativeQuery = true,
//            value = "DELETE FROM person u WEHRE u.id in ?1")
//void deleteUsersWithIds(List<Integer> ids);
    //dapat membuat prosdure yang di simpan di database menggunakan @Procedure
}
