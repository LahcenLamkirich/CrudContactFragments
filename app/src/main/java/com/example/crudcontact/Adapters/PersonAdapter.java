package com.example.crudcontact.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crudcontact.Entities.Person;
import com.example.crudcontact.R;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.view> {

    Context context ;
    ArrayList<Person> persons ;

    public PersonAdapter(Context context, ArrayList<Person> persons) {
        this.context = context;
        this.persons = persons;
    }

    @NonNull
    @Override
    public PersonAdapter.view onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        android.view.View view1  = inflater.inflate(R.layout.customcontact, parent, false);
        return new view(view1);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.view holder, int position) {
        Person person = persons.get(position);
        holder.username.setText(person.getNamePerson());
        holder.phoneNumber.setText(person.getTelephone());
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public class view extends RecyclerView.ViewHolder{

        TextView phoneNumber, username;
        LinearLayout mainLayout ;
        public view(@NonNull android.view.View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.usernameId);
            phoneNumber = itemView.findViewById(R.id.phoneNumber);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }

}
