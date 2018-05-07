package kh.edu.niptict.senddata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String mss = intent.getStringExtra(Const.KEY1);


        int num = intent.getIntExtra("sdf", 30);

        TextView textView = findViewById(R.id.showData4);
        textView.setText(mss+" "+num);



    }
}
