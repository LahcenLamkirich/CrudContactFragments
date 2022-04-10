package com.example.crudcontact;

import  androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.crudcontact.DAO.RoomDb;
import com.example.crudcontact.Entities.Person;
import com.example.crudcontact.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding ;
    RoomDb database ;
    Person p1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // this two lines to adopt the view with the activity :
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());


        // La declaration d'une peson
        p1 = new Person();
        p1.setNamePerson("Lahcen");
        p1.setTelephone("0777208954");
        database.personDao().insert(p1);

        System.out.println(p1.getNamePerson() + " Phone Number : " + p1.getTelephone());

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
