package com.example.crudcontact.DAO;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.crudcontact.Entities.Person;

@Database(entities = {Person.class}, version = 1, exportSchema = true)
public abstract class RoomDb extends RoomDatabase {

    private static RoomDb database;

    // Define database name
    private static String DATABASE_NAME="database";

    public synchronized static RoomDb getInstance(Context context)
    {
        // check condition
        if(database==null)
        {
            // when database is null
            // Initialize database
            database= Room.databaseBuilder(context.getApplicationContext(),RoomDb.class,DATABASE_NAME)
                    .allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        // Return database
        return database;
    }

    public abstract PersonDao personDao();
}
