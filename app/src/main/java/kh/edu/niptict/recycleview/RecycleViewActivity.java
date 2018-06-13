package kh.edu.niptict.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import kh.edu.niptict.recycleview.adapter.RecyclerViewAdapter;

public class RecycleViewActivity extends AppCompatActivity {

    private Button submitBtn;
    private RecyclerView recyclerView;
    private EditText editText;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String> list = new ArrayList<>();
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        submitBtn = findViewById(R.id.submitBtn);
        recyclerView = findViewById(R.id.recycleview);
        editText = findViewById(R.id.editText);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                if(str != "") {
                    list.add(str);
                    adapter.notifyDataSetChanged();

                }
            }
        });

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        list.add("A");
        list.add("B");
        adapter = new RecyclerViewAdapter(list);
        recyclerView.setAdapter(adapter);
    }
}
