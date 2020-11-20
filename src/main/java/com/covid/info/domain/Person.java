package com.covid.info.domain;

import javax.persistence.*;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="firstname")
    private String name;

    @Column(name= "surname")
    private String surname;

    @Column(name="age")
    private int age;

    @Column(name="covidinfo")
    private String covidInfo;

    @Column(name="date")
    private String date;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCovidInfo() {
        return covidInfo;
    }

    public void setCovidInfo(String covidInfo) {
        this.covidInfo = covidInfo;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    public int getId() {
        return id;
    }
}
