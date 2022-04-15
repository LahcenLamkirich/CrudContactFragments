package com.example.crudcontact.Adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crudcontact.Entities.Person;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.view> {
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
