package ru.gbax.simplegroup.test.model;

import java.util.Date;

/**
 * Человек
 * Created by GBAX on 04.07.2015.
 */
public class Person {

    private String firstName;

    private String secondName;

    private String middleName;

    private Date birthDate;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Person copy() {
        Person copy = new Person();
        copy.setBirthDate(this.getBirthDate());
        copy.setFirstName(this.getFirstName());
        copy.setMiddleName(this.getMiddleName());
        copy.setSecondName(this.getSecondName());
        return copy;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
