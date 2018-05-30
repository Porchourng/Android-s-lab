package kh.edu.niptict.toolbar2;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       // ActionBar actionBar = getSupportActionBar();
       // actionBar.setTitle("Search Activity");

        Toolbar toolbar = findViewById(R.id.toolbar2);
        toolbar.setTitle("Toolbar Main2Activity");
        toolbar.setSubtitle("Toolbar Subtitle");
        setSupportActionBar(toolbar);
    }
}
