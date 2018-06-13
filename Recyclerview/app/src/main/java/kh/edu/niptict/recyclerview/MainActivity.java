package kh.edu.niptict.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import kh.edu.niptict.recyclerview.adapter.MovieAdapter;
import kh.edu.niptict.recyclerview.model.Movie;

public class MainActivity extends AppCompatActivity {
    ArrayList<Movie> list = new ArrayList<>();
    RecyclerView.LayoutManager layoutManager;
    MovieAdapter adapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(layoutManager);
        initData();
        adapter = new MovieAdapter(list);
        recyclerView.setAdapter(adapter);


    }

    private void initData() {
        list.add(new Movie("A", "A is drama", 2018));
        list.add(new Movie("B", "B is drama", 2018));
        list.add(new Movie("C", "C is drama", 2018));
        list.add(new Movie("D", "D is drama", 2018));
    }
}
