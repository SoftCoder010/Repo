package com.budgetapp.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.Entity;

/**
 * Created by lapostol on 7/31/2014.
 */
@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private float allocated_budget;

    public Category update(Category category){
        this.name = category.name;
        this.allocated_budget = category.allocated_budget;
        return this;
    }

    @Override
    public String toString() {
        return "Category "+name+" has a budget of "+allocated_budget ;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAllocated_budget(float allocated_budget) {
        this.allocated_budget = allocated_budget;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getAllocated_budget() {
        return allocated_budget;
    }
}
