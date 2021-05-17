package com.example.tuan5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnClickListner {
    RecyclerView rcv_name;
    CustomAdapterRecycler adt;
    List<User> mNames;
    Button btnAdd, btnRemove,btnSave;
    EditText tvSearch;
    DatabaseHandler dataUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNames = new ArrayList<>();
        rcv_name = findViewById(R.id.rcv_name);
        tvSearch = findViewById(R.id.tvSearch);
        btnAdd = findViewById(R.id.btnAdd);
        btnRemove = findViewById(R.id.btnRemove);
        btnAdd = findViewById(R.id.btnAdd);
        btnSave = findViewById(R.id.btnSave);
        btnRemove.setEnabled(false);
        btnSave.setEnabled(false);
//        DataUser dataUser  = new DataUser(this,"userdb.sqlite",null,1);
//        dataUser.addUser(new User(2,"Thai HUy Hoang"));
         dataUser  = new DatabaseHandler(this);
        //Them mot student
//        dataUser.addStudent(new User("Hoang OP"));
        mNames = dataUser.getAllStudents();
//        mNames.add(new Name("Thái Huy Hoàng"));
//        mNames.add(new Name("Thái Huy Hoàng"));
//        mNames.add(new Name("Thái Huy Hoàng"));
//        mNames.add(new Name("Thái Huy Hoàng"));
//        mNames.add(new Name("Thái Huy Hoàng"));
//        mNames.add(new Name("Thái Huy Hoàng"));

        adt = new CustomAdapterRecycler(mNames,this);
        rcv_name.setHasFixedSize(true);
        rcv_name.setAdapter(adt);
        rcv_name.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = tvSearch.getText().toString();
                dataUser.addStudent(new User(name));
                List<User> users =  dataUser.getAllStudents();
                adt.resetList(users);
                tvSearch.setText("");
                btnRemove.setVisibility(View.INVISIBLE);
                btnSave.setVisibility(View.INVISIBLE);
            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = tvSearch.getText().toString();
                dataUser.addStudent(new User(name));
                List<User> users =  dataUser.getAllStudents();
                adt.resetList(users);
                tvSearch.setText("");
                btnRemove.setVisibility(View.INVISIBLE);
                btnSave.setVisibility(View.INVISIBLE);
            }
        });


    }

    @Override
    public void itemClicklistener(User user) {

        btnRemove.setEnabled(true);
        btnSave.setEnabled(true);
        tvSearch.setText(user.getName().toString());
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataUser.deleteStudent(user.getId());
                List<User> users =  dataUser.getAllStudents();
                adt.resetList(users);
                tvSearch.setText("");
                btnRemove.setEnabled(false);
                btnSave.setEnabled(false);
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user.setName(tvSearch.getText().toString());
                dataUser.updateStudent(user);
                List<User> users =  dataUser.getAllStudents();
                adt.resetList(users);
                tvSearch.setText("");
                btnRemove.setEnabled(false);
                btnSave.setEnabled(false);
            }
        });
    }

}