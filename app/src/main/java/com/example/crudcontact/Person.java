package com.example.crudcontact;


public class Person {
    private int idPerson ;
    private String namePerson ;
    private String telephone ;

    public Person(){}
    public Person(int idPerson, String namePerson, String telephone) {
        this.idPerson = idPerson;
        this.namePerson = namePerson;
        this.telephone = telephone;
    }
}
