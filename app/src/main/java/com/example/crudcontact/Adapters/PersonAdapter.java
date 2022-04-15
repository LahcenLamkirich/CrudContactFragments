package com.example.crudcontact.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crudcontact.DAO.RoomDb;
import com.example.crudcontact.Entities.Person;
import com.example.crudcontact.MainActivity;
import com.example.crudcontact.R;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.view> {

    Context context ;
    ArrayList<Person> persons ;
    MainActivity main = new MainActivity();
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

        RoomDb database = RoomDb.getInstance(context);

        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Person p =persons.get(holder.getAdapterPosition());

                final int id = p.getIdPerson();
                System.out.println("The id is " + id);
                String username = p.getNamePerson();
                String phone = p.getTelephone();

                final Dialog dialog=new Dialog(context);

                // set content view
                dialog.setContentView(R.layout.dialogedit);

                //Initialize width
                int width= WindowManager.LayoutParams.MATCH_PARENT;

                //Initialize height
                int height=WindowManager.LayoutParams.WRAP_CONTENT;

                //Set layout
                dialog.getWindow().setLayout(width,height);

                //show dialog
                dialog.show();

                final EditText userEdit = dialog.findViewById(R.id.user);
                final EditText phonEdit = dialog.findViewById(R.id.phone);

                userEdit.setText(username);
                phonEdit.setText(phone);

                Button btnUp = dialog.findViewById(R.id.bt_update);

                btnUp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Dismiss Dialog
                        dialog.dismiss();

                        //Get Updated text from edit text
                        String user12=userEdit.getText().toString().trim();
                        String phone12 = phonEdit.getText().toString().trim();

                        System.out.println(user12 + "   " + phone12);
                        // Update text in database
                        database.personDao().update12(id, user12, phone12);

                        //notify when data is updated
                        persons.clear();
                        persons.addAll(database.personDao().getAll());
                        notifyDataSetChanged();
                    }
                });
            }
        });


        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Person p= persons.get(holder.getAdapterPosition());
                final int id= p.getIdPerson();

                database.personDao().delete(id);
                persons.clear();
                persons.addAll(database.personDao().getAll());
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public class view extends RecyclerView.ViewHolder{

        TextView phoneNumber, username;
        LinearLayout mainLayout ;
        ImageView btnEdit, btnDelete ;
        public view(@NonNull android.view.View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.usernameId);
            phoneNumber = itemView.findViewById(R.id.phoneNumber);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            btnEdit = itemView.findViewById(R.id.editBtn);
            btnDelete = itemView.findViewById(R.id.deleteBtn);
        }
    }

}
