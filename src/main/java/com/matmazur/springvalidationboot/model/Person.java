package com.matmazur.springvalidationboot.model;

import com.matmazur.springvalidationboot.myValidators.EvenNumber;
import com.matmazur.springvalidationboot.myValidators.RealEmail;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Person {


    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @Digits(integer = 4,fraction = 0)
    private int idNumber;
    @Size(min = 8, max = 8)
    private String pesel;
    @RealEmail
    private String email;
    @EvenNumber
    private int numberToValidate;


    public Person() {
    }

    public Person(String name, String surname, int idNumber, String pesel, String email, int numberToValidate) {
        this.name = name;
        this.surname = surname;
        this.idNumber = idNumber;
        this.pesel = pesel;
        this.email = email;
        this.numberToValidate=numberToValidate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", idNumber=" + idNumber +
                ", pesel='" + pesel + '\'' +
                ", email='" + email + '\'' +
                ", numberToValidate=" + numberToValidate +
                '}';
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

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumberToValidate() {
        return numberToValidate;
    }

    public void setNumberToValidate(int numberToValidate) {
        this.numberToValidate = numberToValidate;
    }
}
