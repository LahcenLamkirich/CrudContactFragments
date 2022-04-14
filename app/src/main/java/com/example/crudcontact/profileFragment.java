package com.example.crudcontact;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.crudcontact.DAO.RoomDb;
import com.example.crudcontact.Entities.Person;

public class profileFragment extends Fragment {

    Button btnAdd ;
    EditText username, phoneNumber ;

    RoomDb database ;

    public profileFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_profile, container, false);

        btnAdd = view.findViewById(R.id.btnAdd);
        username = view.findViewById(R.id.username);
        phoneNumber = view.findViewById(R.id.phoneNumber);
        database = RoomDb.getInstance(getContext());
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Person person = new Person();
                person.setNamePerson(username.getText().toString());
                person.setTelephone(phoneNumber.getText().toString());

                database.personDao().insert(person);

            }
        });

        return view ;
    }
}