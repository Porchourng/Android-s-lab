package kh.edu.niptict.fragment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StaticFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_fragment);

        final EditText editText = findViewById(R.id.editText);
        final TextView textView = findViewById(R.id.textView3);

        Button button = findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(StaticFragmentActivity.this, editText.getText().toString(), Toast.LENGTH_SHORT).show();
                textView.setText(editText.getText().toString());
            }
        });
    }
}
