package kh.edu.niptict.room;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

import kh.edu.niptict.room.ViewModel.MainViewModel;
import kh.edu.niptict.room.database.AppDatabase;
import kh.edu.niptict.room.database.Book;
import kh.edu.niptict.room.database.User;
import kh.edu.niptict.room.database.utils.DatabaseInitializer;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        Button getAllUserBtn = findViewById(R.id.button);
        Button findBookByName = findViewById(R.id.button2);
        Button findBookBtn = findViewById(R.id.button3);
        getAllUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAllUser();
            }
        });

        findBookByName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                findUserByAge(35);
                findBookByName("Mike");
            }
        });

        findBookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  findBook("Mike");
                subscribeUiBooks();
            }
        });
    }

    private void findBookByName(String name) {
        mViewModel.findBookByName(name).observe(this, new Observer<List<Book>>() {
            @Override
            public void onChanged(@Nullable List<Book> books) {
                Toast.makeText(getApplicationContext(), books.size()+"", Toast.LENGTH_SHORT).show();
                StringBuilder sb = new StringBuilder();

                for (Book book : books) {
                    sb.append(book.title);
                    sb.append("\n");

                }
                textView.setText(sb.toString());
            }
        });
    }

    private void getAllUser() {
        mViewModel.getAllUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                StringBuilder sb = new StringBuilder();

                for (User user : users) {
                    sb.append(user.name);
                    sb.append("\n");

                }
                textView.setText(sb.toString());
            }
        });
    }



    private void subscribeUiBooks() {

        mViewModel.getBorrowedBookByName("Mike").observe(this, new Observer<List<Book>>() {
            @Override
            public void onChanged(@Nullable List<Book> books) {
                showBooksInUi(books);
            }
        });
    }

    private void showBooksInUi(final @NonNull List<Book> books) {
        StringBuilder sb = new StringBuilder();

        for (Book book : books) {
            sb.append(book.title);
            sb.append("\n");

        }
        textView.setText(sb.toString());
    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }

}
