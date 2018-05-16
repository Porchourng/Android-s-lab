package kh.edu.niptict.saveinstancestate;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    String data = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        final EditText editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = editText.getText().toString();
                textView.setText(data);
            }
        });

        if (savedInstanceState != null) {
            Log.d("Save",savedInstanceState.getString(Const.KEY1));
            textView.setText(savedInstanceState.getString(Const.KEY1));
        }
      //  Log.d("Restore", "True");
    }



//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        Log.d("SaveInsta", data);
//        outState.putString(Const.KEY1, data);
//    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //data = ;
        Log.d("Restore", "true");
        textView.setText(savedInstanceState.getString(Const.KEY1));

    }
}
