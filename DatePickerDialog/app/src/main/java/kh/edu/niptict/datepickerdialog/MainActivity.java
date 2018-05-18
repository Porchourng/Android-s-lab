package kh.edu.niptict.datepickerdialog;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get current date from Calendar
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create DatePickerDialog object
        final DatePickerDialog datePickerDialog = new DatePickerDialog(this, this, year, month, day);


        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });


//        final DatePickerDialog datePickerDialog1 = new DatePickerDialog(this,
//                new DatePickerDialog.OnDateSetListener() {
//
//                    @Override
//                    public void onDateSet(DatePicker view, int year,
//                                          int month, int dayOfMonth) {
//                        Toast.makeText(MainActivity.this, "Year : "+year+" month: "+month+" day: "+dayOfMonth, Toast.LENGTH_SHORT).show();
//                    }
//                }, year, month, day);
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Toast.makeText(this, "Year : "+year+" month: "+month+" day: "+dayOfMonth, Toast.LENGTH_SHORT).show();
    }
}
