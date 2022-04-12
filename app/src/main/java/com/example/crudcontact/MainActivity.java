package com.example.crudcontact;

import  androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.crudcontact.DAO.RoomDb;
import com.example.crudcontact.Entities.Person;
import com.example.crudcontact.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding ;
    RoomDb database ;
    Person p1, p2, p3 ;
    List<Person> personList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // this two lines to adopt the view with the activity :
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        // we have to add this line to avoid the null pointer Exception
        database = RoomDb.getInstance(this);

        // La declaration d'une peson
        p1 = new Person();
        p2 = new Person();
        p3 = new Person();
        p1.setNamePerson("Lahcen");
        p1.setTelephone("0777208954");
        p2.setNamePerson("Ahmed");
        p2.setTelephone("0678954523");
        p3.setNamePerson("Yasser");
        p3.setTelephone("0741526389");
        // add a person
        database.personDao().insert(p1);
        database.personDao().insert(p2);
        database.personDao().insert(p3);
        System.out.println(p1.getNamePerson() + " Phone Number : " + p1.getTelephone());
        //get All the persons :
        personList = database.personDao().getAll();
        for(Person p:personList) {
            System.out.println(p.getNamePerson() + " phone number : " + p.getTelephone());
            String contcat = "User " + p.getNamePerson().toString() + " Phone: " + p.getTelephone().toString();
            Toast.makeText(this, contcat, Toast.LENGTH_SHORT).show();
        }
        switchFragment(new homeFragment());

        // The Traitement start from here :

        mainBinding.bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.home:
                        switchFragment(new homeFragment());
                        break;
                    case R.id.addProfile:
                        switchFragment(new profileFragment());
                        break;
                }

                return true;
            }
        });

    }

    public void switchFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }




}
