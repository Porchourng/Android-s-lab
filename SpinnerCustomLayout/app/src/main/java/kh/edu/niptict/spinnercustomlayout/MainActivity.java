package kh.edu.niptict.spinnercustomlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import kh.edu.niptict.spinnercustomlayout.adapter.ItemsAdapter;
import kh.edu.niptict.spinnercustomlayout.model.Items;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    ArrayList<Items> itemsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
            Add static data, in this case you can take data from database,
            server(api) or static data
         */
        itemsList.add(new Items(R.mipmap.ic_launcher, "Test1"));
        itemsList.add(new Items(R.mipmap.ic_launcher, "Test2"));
        itemsList.add(new Items(R.mipmap.ic_launcher, "Test3"));
        itemsList.add(new Items(R.mipmap.ic_launcher, "Test4"));

        // Create adapter with data and custom layout
        ItemsAdapter adapter = new ItemsAdapter(this, R.layout.list_items, itemsList);

        // Create Spinner object with id spinner
        Spinner spinner = findViewById(R.id.spinner);

        // Set adapter into Spinner
        spinner.setAdapter(adapter);

//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String item = itemsList.get(position).getName();
//                Toast.makeText(MainActivity.this, item, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

        // Add listener into Spinner
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // Get selected item by position selection from user
        String item = itemsList.get(position).getName();
        // show information of selected item to User
        Toast.makeText(this, item, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
