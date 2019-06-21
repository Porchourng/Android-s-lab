package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.recyclerview.adapter.WordListAdapter;
import com.example.recyclerview.model.Movie;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final LinkedList<Movie> movieLinkedList = new LinkedList<>();
        // Static Content
        for (int i = 0; i<15; i++) {
            movieLinkedList.add(new Movie(R.mipmap.ic_launcher_round, "Title "+i, "Des"+i));
        }

        // Create object RecylerView
        RecyclerView mRecyclerView = findViewById(R.id.recyclerview);

        // Create object adapter
        final WordListAdapter mAdapter = new WordListAdapter(this,movieLinkedList);

        // Set adapter into Recylerview
        mRecyclerView.setAdapter(mAdapter);

        // set layoutmanager to define linear or grid view
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        //mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3, RecyclerView.HORIZONTAL, false));

        Button addBtn = findViewById(R.id.button);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movieLinkedList.add(new Movie(R.mipmap.ic_launcher, "Add New", "Des"));
                mAdapter.notifyDataSetChanged();
            }
        });
    }
}
