package kh.edu.niptict.fragment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button staticFrgBtn = findViewById(R.id.btn1);
        staticFrgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StaticFragmentActivity.class);
                startActivity(intent);
            }
        });

        Button dynamicBtn = findViewById(R.id.btn2);
        dynamicBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DynamicFragmentActivity.class);
                startActivity(intent);
            }
        });
    }
}
