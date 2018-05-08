package kh.edu.niptict.receivedatabackfromprevactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import kh.edu.niptict.receivedatabackfromprevactivity.Const.Const;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button button = findViewById(R.id.dismissActivityBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create intent object for sending data back
                Intent intent = new Intent();

                // Data for sending back
                String data = "From Previous Activity";

                // Put Data into intent object with KEY1
                intent.putExtra(Const.KEY1,data);

                // Send data back to previous activity by specify RESULT is OK
                setResult(RESULT_OK, intent);

                // Dismiss activity
                finish();
            }
        });
    }
}
