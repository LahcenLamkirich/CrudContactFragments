package com.example.crudcontact.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.RenameTable;

@Entity
public class Person {
    @PrimaryKey
    private int idPerson ;

    @ColumnInfo(name = "name")
    private String namePerson ;
    @ColumnInfo(name = "PhoneNumber")
    private String telephone ;

    public Person(){}
    public Person(int idPerson, String namePerson, String telephone) {
        this.idPerson = idPerson;
        this.namePerson = namePerson;
        this.telephone = telephone;
    }
}
