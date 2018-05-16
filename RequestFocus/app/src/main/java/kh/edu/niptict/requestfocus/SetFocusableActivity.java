package kh.edu.niptict.requestfocus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class SetFocusableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_focusable);

        EditText editText = findViewById(R.id.editText10);
        // disable focus on editText in Java code or XML
        editText.setFocusable(false);
    }
}
