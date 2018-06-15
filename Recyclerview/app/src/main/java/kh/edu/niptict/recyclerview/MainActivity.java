package kh.edu.niptict.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
      //  layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
       // layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true);
        /* make scroll horizontal

            true -> add new item on the first
        */
        //layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);

        layoutManager = new GridLayoutManager(this, 2);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true); // use it in case you clearly each item(row) has fix size
        initData();
        adapter = new MovieAdapter(list);
        recyclerView.setAdapter(adapter);

        Button submitBtn = findViewById(R.id.submitBtn);
        final EditText title = findViewById(R.id.addTitle);
        final EditText des = findViewById(R.id.addDes);
        final EditText year = findViewById(R.id.addYear);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Movie m = new Movie(title.getText().toString(), des.getText().toString(), Integer.parseInt(year.getText().toString()));
                list.add(m);
                adapter.notifyDataSetChanged();
            }
        });


    }

    private void initData() {
        list.add(new Movie("A", "A is drama", 2018));
        list.add(new Movie("B", "B is drama", 2018));
        list.add(new Movie("C", "C is drama", 2018));
        list.add(new Movie("D", "D is drama", 2018));
    }
}
