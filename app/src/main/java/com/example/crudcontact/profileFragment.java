package com.example.crudcontact;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class profileFragment extends Fragment {

    Button btnAdd ;
    EditText username, phoneNumber ;


    public profileFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_profile, container, false);

        btnAdd = view.findViewById(R.id.btnAdd);
        username = view.findViewById(R.id.username);
        phoneNumber = view.findViewById(R.id.phoneNumber);



        return view ;
    }
}