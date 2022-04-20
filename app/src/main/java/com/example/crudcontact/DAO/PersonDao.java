package com.example.crudcontact.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.crudcontact.Entities.Person;

import java.util.List;

@Dao
public interface PersonDao {

    @Query("SELECT * FROM person")
    List<Person> getAll();

    @Query("SELECT * FROM person WHERE idPerson=:id")
    Person getPersonById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Person person);

    @Query("DELETE FROM person WHERE idPerson =:id")
    void delete(int id);

    @Query("UPDATE person SET name=:nameP AND phoneNumber=:tel where idPerson=:id")
    void update(int id, String nameP, String tel);

    @Query("UPDATE person SET name=:nameP,phoneNumber=:tel where idPerson=:sid")
    void update12(int sid, String nameP, String tel);

    @Query("SELECT * FROM person where name LIKE :key || '%' ")
    List<Person> getAllByname(String key);
    
}
