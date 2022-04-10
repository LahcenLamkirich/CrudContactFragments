package com.example.crudcontact.DAO;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.crudcontact.Entities.Person;

@Database(entities = {Person.class}, version = 1, exportSchema = false)
public abstract class RoomDb extends RoomDatabase {
    public abstract PersonDao personDao();
}
