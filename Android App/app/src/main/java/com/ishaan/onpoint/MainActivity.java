package com.ishaan.onpoint;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.WindowManager;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private ArrayList<String> senderNameArrayList = new ArrayList<String>();
    private ArrayList<String> summaryArrayList = new ArrayList<String>();
    private EditText searchBar;
    private ArrayList<String> searchedNameArrayList = new ArrayList<String>();
    private ArrayList<String> searchedSummaryArrayList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        searchBar = findViewById(R.id.searchBar);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);

        senderNameArrayList.add("ishaan99ohri@gmail.com");
        senderNameArrayList.add("ishaan99ohri@gmail.com");
        senderNameArrayList.add("ishaan99ohri@gmail.com");
        senderNameArrayList.add("ishaan99ohri@gmail.com");

        summaryArrayList.add("This is sample summary of your email. Click here to read the full summary");
        summaryArrayList.add("This is sample summary of your email. Click here to read the full summary");
        summaryArrayList.add("This is sample summary of your email. Click here to read the full summary");
        summaryArrayList.add("This is sample summary of your email. Click here to read the full summary");

        senderNameArrayList.add("ishaan99ohri@gmail.com");
        senderNameArrayList.add("ishaan99ohri@gmail.com");
        senderNameArrayList.add("ishaan99ohri@gmail.com");
        senderNameArrayList.add("ishaan99ohri@gmail.com");

        summaryArrayList.add("This is sample summary of your email. Click here to read the full summary");
        summaryArrayList.add("This is sample summary of your email. Click here to read the full summary");
        summaryArrayList.add("This is sample summary of your email. Click here to read the full summary");
        summaryArrayList.add("This is sample summary of your email. Click here to read the full summary");
        senderNameArrayList.add("akshitsadana@gmail.com");
        senderNameArrayList.add("akshitsadana@gmail.com");
        senderNameArrayList.add("akshitsadana@gmail.com");
        senderNameArrayList.add("akshitsadana@gmail.com");

        summaryArrayList.add("This is sample summary of your email. Click here to read the full summary");
        summaryArrayList.add("This is sample summary of your email. Click here to read the full summary");
        summaryArrayList.add("This is sample summary of your email. Click here to read the full summary");
        summaryArrayList.add("This is sample summary of your email. Click here to read the full summary");

        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                searchedSummaryArrayList = new ArrayList<>();
                searchedNameArrayList = new ArrayList<>();
                String searchText = String.valueOf(charSequence).toLowerCase();
                Log.i("INFO",String.valueOf(charSequence).toLowerCase());
                for (String name : senderNameArrayList)
                {
                    if(name.toLowerCase().contains(searchText))
                    {
                        Log.i("INFO",name);
                        searchedNameArrayList.add(name);
                        searchedSummaryArrayList.add(summaryArrayList.get(senderNameArrayList.indexOf(name)));
                    }
                }
                Log.i("INFO","out");
                recyclerViewAdapter = new RecyclerViewAdapter(searchedNameArrayList,searchedSummaryArrayList, MainActivity.this);
                recyclerView.setAdapter(recyclerViewAdapter);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



        recyclerViewAdapter = new RecyclerViewAdapter(senderNameArrayList,summaryArrayList, MainActivity.this);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
