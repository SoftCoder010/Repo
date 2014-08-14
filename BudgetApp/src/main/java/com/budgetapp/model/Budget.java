package com.budgetapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by lapostol on 8/5/2014.
 */
@Entity
@Table(name="budget")
public class Budget {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String type;

    private Integer day1;

    private Integer day2;

    private Integer month;

    private Float value;

    private Boolean isDefault;

    @Override
    public String toString() {
        return "Budget{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", day1=" + day1 +
                ", day2=" + day2 +
                ", month=" + month +
                ", value=" + value +
                ", isDefault=" + isDefault +
                '}';
    }

    public Budget update(Budget budget){
        this.name = budget.name;
        this.day1 = budget.day1;
        this.day2 = budget.day2;
        this.type = budget.type;
        this.value = budget.value;
        this.isDefault = budget.isDefault;
        return this;
    }

    public Integer getDay2() {
        return day2;
    }

    public void setDay2(Integer day2) {
        this.day2 = day2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getDay1() {
        return day1;
    }

    public void setDay1(Integer day1) {
        this.day1 = day1;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

}
