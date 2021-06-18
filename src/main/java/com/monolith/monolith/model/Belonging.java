/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monolith.monolith.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author user
 */
@Entity
public class Belonging {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "quantity")
    private Integer quantity;

    public Belonging() {
    }
    
     public Belonging(String name, Integer quantity, Person person) {
        this.name = name;
        this.quantity = quantity;
        this.person = person;
    }

    public Belonging(String name, Integer quantity, Person person, Brand brand) {
        this.name = name;
        this.quantity = quantity;
        this.person = person;
    }
    
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    
    //ToBelonging
   @ManyToOne
   @JoinColumn(name = "person", nullable=false)
   private Person person;
   
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
   
   //ToBrand 
   @ManyToOne
   @JoinColumn(name = "brand", nullable=true)
   private Brand brand;

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
  
}
