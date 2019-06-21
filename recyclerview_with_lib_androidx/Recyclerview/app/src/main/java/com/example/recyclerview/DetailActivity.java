package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.recyclerview.Cons.Const;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        // retieve intent/data
        Intent intent = getIntent();

        // extract data from intent
        String title = intent.getStringExtra(Const.KEY_TITLE);

        TextView textView = findViewById(R.id.textView);

        // set title to textview
        textView.setText(title);
    }
}
