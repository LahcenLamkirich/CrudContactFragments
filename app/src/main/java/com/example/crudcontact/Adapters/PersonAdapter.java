package com.example.crudcontact.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crudcontact.Entities.Person;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.view> {

    Context context ;
    ArrayList<Person> person_ids, usernames, phoneNumbers ;

    public PersonAdapter(Context context, ArrayList<Person> person_ids, ArrayList<Person> usernames, ArrayList<Person> phoneNumbers) {
        this.context = context;
        this.person_ids = person_ids;
        this.usernames = usernames;
        this.phoneNumbers = phoneNumbers;
    }

    @NonNull
    @Override
    public PersonAdapter.view onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.view holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class view extends RecyclerView.ViewHolder{

        public view(@NonNull View itemView) {
            super(itemView);
        }

    }
}
