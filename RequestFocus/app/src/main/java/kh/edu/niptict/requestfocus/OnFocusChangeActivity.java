package kh.edu.niptict.requestfocus;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class OnFocusChangeActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_focus_change);

        EditText editText = findViewById(R.id.editText11);

        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    Toast.makeText(OnFocusChangeActivity.this, "editText11", Toast.LENGTH_SHORT).show();
                    Log.d("EditText", "11");
                }
            }
        });

        EditText editText1 = findViewById(R.id.editText12);
        editText1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    Toast.makeText(OnFocusChangeActivity.this, "editText12", Toast.LENGTH_SHORT).show();
                    Log.d("EditText", "12");
                }

            }
        });

        EditText editText2 = findViewById(R.id.editText13);
        editText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    Toast.makeText(OnFocusChangeActivity.this, "editText13", Toast.LENGTH_SHORT).show();
                    Log.d("EditText", "13");
                } else {

                }
            }
        });



    }
}
