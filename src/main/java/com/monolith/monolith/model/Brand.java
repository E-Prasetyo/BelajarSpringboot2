/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monolith.monolith.model;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author user
 */
@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;

    @Column(name = "name", length = 100)
    private String name;

    public Brand() {
    }
    
    public Brand(String name) {
        this.name = name;
    }
    
    public Brand(String name,Country country) {
        this.name = name;
    }
    
     public Brand(String name,Belonging belonging) {
        this.name = name;
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
    
    @ManyToOne
   @JoinColumn(name = "country", nullable=true)
   private Country country;
   
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
    
   @OneToMany(mappedBy = "brand")
   private List<Belonging> belongings;

    public List<Belonging> getBelongingss() {
        return belongings;
    }

    public void setBelongingss(List<Belonging> belongings) {
        this.belongings = belongings;
    }
    
}
