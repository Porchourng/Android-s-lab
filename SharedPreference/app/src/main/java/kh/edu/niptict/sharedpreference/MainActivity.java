package kh.edu.niptict.sharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView showData;
    EditText getData;
    Button submitBtn;
    Button showBtn;
    private String sharedPrefile = "kh.edu.niptict.sharedpreference";
    private final String KEY1 = "name";

    private SharedPreferences mPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showData = findViewById(R.id.textView);
        getData = findViewById(R.id.editText);
        submitBtn = findViewById(R.id.submit);
        showBtn = findViewById(R.id.show);

        mPref = getSharedPreferences(sharedPrefile, MODE_PRIVATE);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = getData.getText().toString();
                getData.setText("");

                SharedPreferences.Editor shp = mPref.edit();
                shp.putString(KEY1, str);
                shp.apply();
            }
        });

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showData.setText(mPref.getString(KEY1, "Not Found"));

            }
        });
    }
}
