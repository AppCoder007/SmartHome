package com.example.donavarghese.smarthome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FrontDoorLog extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView recyclerView1;

    private RecyclerView.Adapter adapter;
    private RecyclerView.Adapter adapter1;

    private List<ListItem> listItems;

    private List<ListItem> listItems1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_door_log);
        ArrayList<String>TextBox =new ArrayList<>();
        ArrayList<String>TextBox1 ;
        Intent in = getIntent();
        Intent in1 = getIntent();
        TextBox = in.getStringArrayListExtra("TextBox");
        TextBox1 = in1.getStringArrayListExtra("TextBox1");

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listItems = new ArrayList<>();

        recyclerView1 = (RecyclerView) findViewById(R.id.recyclerView1);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        listItems1 = new ArrayList<>();


        for(int i = 0; i < TextBox.size() ; i++){

            ListItem listItem = new ListItem(TextBox.get(i) , "Door Open");
            listItems.add(listItem); //add the item to the ArrayList!
        }

        for(int i = 0; i < TextBox1.size() ; i++){

            ListItem listItem1 = new ListItem(TextBox1.get(i) , "Door Close");
            listItems1.add(listItem1); //add the item to the ArrayList!
        }


        adapter = new MyAdapter(listItems, this);
        //we have the adapter
        recyclerView.setAdapter(adapter);



        adapter1 = new MyAdapter(listItems1, this);
        //we have the adapter
        recyclerView1.setAdapter(adapter1);
    }
}
