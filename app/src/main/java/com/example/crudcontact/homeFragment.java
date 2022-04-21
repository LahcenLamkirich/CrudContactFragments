package com.example.crudcontact;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
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
import java.util.List;


public class homeFragment extends Fragment {

    // la declaration des attributs :

    EditText username, password, searchText ;
//    Button btnSave, searchBtn;
//    ArrayList<Person> persons ;
    public homeFragment(){}
    RecyclerView recyclerView;
    PersonAdapter personAdapter ;
    ArrayList<Person> contacts = new ArrayList<>();
    RoomDb database ;
    LinearLayoutManager linearLayoutManager;
    ArrayList<Person> filterList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_home, container, false);

    recyclerView = view.findViewById(R.id.recycleView);
    database = RoomDb.getInstance(getContext());
    contacts = (ArrayList<Person>) database.personDao().getAll();
    searchText = view.findViewById(R.id.searchEditTxt);
    linearLayoutManager=new LinearLayoutManager(getContext());
    recyclerView.setLayoutManager(linearLayoutManager);
    personAdapter = new PersonAdapter(getContext(), contacts);
    recyclerView.setAdapter(personAdapter);


    searchText.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            filterList.clear();
            Filter(editable.toString());
        }
    });

    return view ;

   }

    private void Filter(String text){
            String str = searchText.getText().toString();
            System.out.println("The string taped is : " + str);
            System.out.println("The person getted : " + database.personDao().getPersonByName(str).toString());
            if(str.isEmpty()){
                recyclerView.setAdapter(personAdapter);
                personAdapter.notifyDataSetChanged();
                filterList.clear();
            }
            else {
                filterList.add(database.personDao().getPersonByName(str));
                recyclerView.setAdapter(new PersonAdapter(getContext(), filterList));
                personAdapter.notifyDataSetChanged();
            }
    }

}

