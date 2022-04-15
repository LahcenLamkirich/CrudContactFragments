package com.example.crudcontact;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crudcontact.Adapters.PersonAdapter;
import com.example.crudcontact.DAO.RoomDb;
import com.example.crudcontact.Entities.Person;

import java.util.ArrayList;


public class homeFragment extends Fragment {

    // la declaration des attributs :

    EditText username, password ;
    Button btnSave ;
    public homeFragment(){}
    RecyclerView recyclerView;
    PersonAdapter personAdapter ;
    ArrayList<Person> usernames, phoneNumbers ;
    RoomDb database ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_home, container, false);

    database = RoomDb.getInstance(getContext());
    recyclerView = view.findViewById(R.id.recycleView);

    usernames = new ArrayList<>();
    phoneNumbers = new ArrayList<>();

//    usernames = (ArrayList<Person>) database.personDao().getAll();
//        for (Person p:usernames) {
//            System.out.println(p.getNamePerson());
//        }

        
    return view ;
   }


}