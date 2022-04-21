package com.example.crudcontact.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "person")
public class Person {
    @PrimaryKey(autoGenerate = true)
    private int idPerson ;

    @ColumnInfo(name = "name")
    private String namePerson ;
    @ColumnInfo(name = "PhoneNumber")
    private String telephone;

    public Person(){}
    public Person(int idPerson, String namePerson, String telephone) {
        this.idPerson = idPerson;
        this.namePerson = namePerson;
        this.telephone = telephone;
    }


    public int getIdPerson() {
        return idPerson;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "idPerson=" + idPerson +
                ", namePerson='" + namePerson + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
