package com.example.crudcontact.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.crudcontact.Entities.Person;

import java.util.List;

@Dao
public interface PersonDao {

    @Query("SELECT * FROM person")
    List<Person> getAll();

    @Query("SELECT * FROM person WHERE idPerson=:id")
    Person getPersonById(int id);

    @Insert
    void insert(int id, String name, String telephone);

    @Query("DELETE FROM person WHERE idPerson =:id")
    void delete(int id);

    @Query("UPDATE person SET name=:nameP AND phoneNumber=:tel")
    void update(String nameP, String tel);
    
}
