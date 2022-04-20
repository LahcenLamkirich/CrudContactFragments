package com.example.crudcontact;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.crudcontact.Adapters.PersonAdapter;
import com.example.crudcontact.DAO.RoomDb;
import com.example.crudcontact.Entities.Person;

import java.util.ArrayList;


public class homeFragment extends Fragment {

    // la declaration des attributs :

    EditText username, password, searchText ;
    Button btnSave, searchBtn;

    public homeFragment(){}
    RecyclerView recyclerView;
    PersonAdapter personAdapter ;
    ArrayList<Person> contacts = new ArrayList<>();
    RoomDb database ;
    LinearLayoutManager linearLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_home, container, false);

    recyclerView = view.findViewById(R.id.recycleView);
    database = RoomDb.getInstance(getContext());
    contacts = (ArrayList<Person>) database.personDao().getAll();
    searchText = view.findViewById(R.id.searchEditTxt);
    searchBtn = view.findViewById(R.id.btnIconSearch);
    linearLayoutManager=new LinearLayoutManager(getContext());
    recyclerView.setLayoutManager(linearLayoutManager);
    personAdapter = new PersonAdapter(getContext(), contacts);
    recyclerView.setAdapter(personAdapter);

    searchBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            System.out.println("The username searched is : " + searchText.getText().toString());
        }
    });



    return view ;
   }
}