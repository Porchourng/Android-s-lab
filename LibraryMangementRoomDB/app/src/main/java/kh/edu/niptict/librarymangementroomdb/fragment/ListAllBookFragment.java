package kh.edu.niptict.librarymangementroomdb.fragment;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import kh.edu.niptict.librarymangementroomdb.R;
import kh.edu.niptict.librarymangementroomdb.database.AppDatabase;
import kh.edu.niptict.librarymangementroomdb.database.MainViewModel;
import kh.edu.niptict.librarymangementroomdb.database.entity.Book;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListAllBookFragment extends Fragment {
    private MainViewModel mViewModel;
    private TextView textView;
    public static ListAllBookFragment newInstance() {
        return new ListAllBookFragment();
    }
   // AppDatabase mDb;
    public ListAllBookFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

       // mDb = AppDatabase.getDatabaseBuilder(getContext());

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_all_book, container, false);

        final EditText titleEt = view.findViewById(R.id.titleEt);
        final EditText isbnEt = view.findViewById(R.id.isbnEt);

        Button submitBtn = view.findViewById(R.id.submitBookBtn);
        Button refreshBtn = view.findViewById(R.id.refreshBookBtn);
        textView = view.findViewById(R.id.listAllBookTv);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book(titleEt.getText().toString(), isbnEt.getText().toString());

               // mDb.bookModel().insertNewBook(book);

                mViewModel.insertNewBook(book);
                titleEt.setText("");
                isbnEt.setText("");
            }
        });

        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAllBook();
                getAllBookWithoutLiveData();
            }
        });

        return view;
    }

    private void getAllBookWithoutLiveData() {
       // List<Book> books = mDb.bookModel().getAllBookNoLiveData();

//        StringBuilder str = new StringBuilder();
//        for (Book book: books) {
//            str.append(book.getTitle()+"\n");
//        }
//
//        textView.setText(str);
    }

    private void getAllBook() {
        mViewModel.getAllBooks().observe(this, new Observer<List<Book>>() {
            @Override
            public void onChanged(@Nullable List<Book> books) {
                StringBuilder str = new StringBuilder();
                for (Book book: books) {
                    str.append(book.getTitle()+"\n");
                }

                textView.setText(str);
            }
        });
    }

}
