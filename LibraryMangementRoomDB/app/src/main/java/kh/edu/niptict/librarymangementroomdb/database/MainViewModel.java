package kh.edu.niptict.librarymangementroomdb.database;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.util.List;

import kh.edu.niptict.librarymangementroomdb.database.dao.UserDao;
import kh.edu.niptict.librarymangementroomdb.database.entity.Book;
import kh.edu.niptict.librarymangementroomdb.database.entity.User;

public class MainViewModel extends AndroidViewModel{
    private AppDatabase mDb;

    public MainViewModel(@NonNull Application application) {
        super(application);
        createDb();
    }

    public void createDb() {
        mDb = AppDatabase.getDatabaseBuilder(this.getApplication());
    }

    public void insertNewBook(Book book) {
        new insertAsyncTask().execute(book);
    }

    public LiveData<List<Book>> getAllBooks() {
        return mDb.bookModel().getAllBook();
    }

    private class insertAsyncTask extends AsyncTask<Book, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(final Book... books) {
            mDb.bookModel().insertNewBook(books[0]);
            //mDb.bookModel().insertMultipleBook(books[0], books[1]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
}
