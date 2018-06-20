package kh.edu.niptict.room;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import kh.edu.niptict.room.database.AppDatabase;
import kh.edu.niptict.room.database.User;
import kh.edu.niptict.room.database.utils.DatabaseInitializer;

public class Main2Activity extends AppCompatActivity {
    private AppDatabase mDb;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);


        mDb = AppDatabase.getDatabaseBuilder(getApplicationContext());
        populateDb();


        Button getAllUserBtn = findViewById(R.id.button);
        Button findUserByAgeBtn = findViewById(R.id.button2);
        Button findBookBtn = findViewById(R.id.button3);
        getAllUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchData();
            }
        });

        findUserByAgeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                findUserByAge(35);
            }
        });

        findBookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  findBook("Mike");
            }
        });

    }

    private void populateDb() {
        DatabaseInitializer.populateAsync(mDb);
    }

    private void fetchData() {
        // Note: this kind of logic should not be in an activity.
        StringBuilder sb = new StringBuilder();
        List<User> youngUsers = mDb.userModel().findUsersYoungerThanSolution(35);
        for (User youngUser : youngUsers) {
            sb.append(String.format(Locale.US,
                    "%s, %s (%d)\n", youngUser.lastName, youngUser.name, youngUser.age));
        }
        textView.setText(sb);
    }
}
