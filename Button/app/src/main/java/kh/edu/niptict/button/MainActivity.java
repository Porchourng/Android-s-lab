package kh.edu.niptict.button;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        final CheckBox checkBox = findViewById(R.id.checkBox);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // check if checkBox is check
                if (checkBox.isChecked()) {
                 //   Toast.makeText(MainActivity.this, "Checkbox", Toast.LENGTH_SHORT).show();
                    Log.e("checkBox", "true");
                } else {
                    Log.e("checkBox", "False");
                }

            }
        });

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.radioButton:
                        Toast.makeText(MainActivity.this, "radioButton", Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.radioButton2:
                        Toast.makeText(MainActivity.this, "radioButton2", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton3:
                        Toast.makeText(MainActivity.this, "radioButton3", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        FloatingActionButton button1 = findViewById(R.id.floatingActionButton);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "floatingActionButton", Toast.LENGTH_SHORT).show();
            }
        });

        final ToggleButton toggleButton = findViewById(R.id.toggleButton);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, toggleButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        final Switch switchBtn = findViewById(R.id.switch1);
        switchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Switch", switchBtn.isChecked()+"");

            }
        });

    }
}
