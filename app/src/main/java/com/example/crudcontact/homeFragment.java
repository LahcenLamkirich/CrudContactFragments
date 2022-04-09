package com.example.crudcontact;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class homeFragment extends Fragment {
    EditText username, password ;
    Button btnSave ;
    public homeFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_home, container, false);



    username = view.findViewById(R.id.usernameId);
    password = view.findViewById(R.id.passwordId);
    btnSave = view.findViewById(R.id.saveId);

    btnSave.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String usernameString = username.getText().toString();
            String passwordString = password.getText().toString();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("User: ");
            stringBuilder.append(usernameString);
            stringBuilder.append(" Pass: ");
            stringBuilder.append(passwordString);
            String res = stringBuilder.toString();
            Toast.makeText(getContext(),res, Toast.LENGTH_LONG).show();

            username.setText("");
            password.getText().clear();
        }
    });

        return view ;
   }





}