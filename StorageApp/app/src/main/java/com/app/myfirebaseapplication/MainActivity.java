package com.app.myfirebaseapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    private RecyclerView recyclerView;
    ItemAdapter adapter;
    DatabaseReference mbase;
    FloatingActionButton addButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mbase = FirebaseDatabase.getInstance().getReference("recyclerview");

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<ItemModel> options = new FirebaseRecyclerOptions.Builder<ItemModel>().setQuery(mbase, ItemModel.class).build();

        adapter = new ItemAdapter(options);

        recyclerView.setAdapter(adapter);

        addButton = (FloatingActionButton) findViewById(R.id.addButton);
        addItem();
    }

    @Override
    protected void onStart(){
        super.onStart();
        adapter.startListening();
    }

    private void addItem(){
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAddItem();
            }
        });
    }
    private void onAddItem(){
        startActivity(new Intent(MainActivity.this, AddItem.class));
    }


    @Override
    protected void onStop(){
        super.onStop();
        adapter.stopListening();
    }


}