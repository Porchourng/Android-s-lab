package kh.edu.niptict.room;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import kh.edu.niptict.room.database.AppDatabase;
import kh.edu.niptict.room.database.Book;
import kh.edu.niptict.room.database.User;
import kh.edu.niptict.room.database.utils.DatabaseInitializer;

public class MainActivity extends AppCompatActivity {

    private AppDatabase mDb;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
     //   mDb = AppDatabase.getInMemoryDatabase(getApplicationContext());
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
                findUserByAge(35);
            }
        });

        findBookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findBook("Mike");
            }
        });




    }

    private void populateDb() {
       // DatabaseInitializer.populateSync(mDb);
        DatabaseInitializer.populateAsync(mDb);
    }

    private void fetchData() {
        // Note: this kind of logic should not be in an activity.
        new AsyncTask<Void, Void, List<User>>() {
            @Override
            protected List<User> doInBackground(Void... voids) {
                List<User> youngUsers = mDb.userModel().findUsersYoungerThan(35);

                return youngUsers;
            }

            @Override
            protected void onPostExecute(List<User> users) {
                StringBuilder sb = new StringBuilder();
                for (User youngUser : users) {
                    sb.append(String.format(Locale.US,
                            "%s, %s (%d)\n", youngUser.lastName, youngUser.name, youngUser.age));
                }
                textView.setText(sb);
            }
        }.execute();

    }

    private void findUserByAge(int age) {
        new AsyncTask<Integer, Void, List<User> >() {

            @Override
            protected List<User> doInBackground(Integer... integers) {
                List<User> users = mDb.userModel().findYoungerThan(integers[0]);
                return users;
            }

            @Override
            protected void onPostExecute(List<User> users) {
                super.onPostExecute(users);
                StringBuilder sb = new StringBuilder();
                for (User youngUser : users) {
                    sb.append(String.format(Locale.US,
                            "%s, %s (%d)\n", youngUser.lastName, youngUser.name, youngUser.age));
                }
                textView.setText(sb);
            }
        }.execute(age);
    }

    private void findBook(String userName) {
        new AsyncTask<String, Void, List<Book> >() {

            @Override
            protected List<Book> doInBackground(String... strings) {
                List<Book> books = mDb.bookModel().findBooksBorrowedByNameSync(strings[0]);
                return books;
            }

            @Override
            protected void onPostExecute(List<Book> books) {
                StringBuilder sb = new StringBuilder();
                for (Book book : books) {
                    sb.append(book.title);
                    sb.append("\n");
                }
                textView.setText(sb.toString());
            }
        }.execute(userName);
    }
}
