package kh.edu.niptict.receivedatabackfromprevactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import kh.edu.niptict.receivedatabackfromprevactivity.Const.Const;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create object Button by specify by ID
        Button button = findViewById(R.id.goToNewActivity);

        // set action lisner to Button inorder to handle action
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent, Const.REQUESTCODE1);
            }
        });

        textView = findViewById(R.id.displayDataback);
    }


    // Get data back from previous activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Const.REQUESTCODE1 && resultCode == RESULT_OK) {
                //get databack by intent object with Key1
                String receiveData = data.getStringExtra(Const.KEY1);
                // Display receiveData to textview
                textView.setText(receiveData);
        }
    }
}
