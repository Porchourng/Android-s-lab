package kh.edu.niptict.requestfocus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class RequestFocusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_focus);

        EditText editText = findViewById(R.id.editText5);
        editText.requestFocus();
    }
}
