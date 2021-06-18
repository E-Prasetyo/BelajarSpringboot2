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
import javax.persistence.OneToMany;

/**
 *
 * @author user
 */
@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;

    @Column(name = "name", length = 100)
    private String name;

    public Country() {
    }

    public Country(String name) {
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
    
    
   @OneToMany(mappedBy = "country")
   private List<Brand> brand;

    public List<Brand> getBrands() {
        return brand;
    }

    public void setBrands(List<Brand> brand) {
        this.brand = brand;
    }
    
    
}
