package kh.edu.niptict.timepickerdialog;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        Calendar c = Calendar.getInstance();
        int hourOfDay = c.get(c.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        final TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(MainActivity.this, "Hour: "+hourOfDay+" mn: "+minute, Toast.LENGTH_SHORT).show();
            }
        }, hourOfDay, minute, true);
        timePickerDialog.setTitle("Select Time");


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog.show();
            }
        });
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Toast.makeText(this, "Hour: "+hourOfDay+" mn: "+minute, Toast.LENGTH_SHORT).show();
    }
}
