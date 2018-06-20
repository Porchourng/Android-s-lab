package kh.edu.niptict.room.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import kh.edu.niptict.room.database.AppDatabase;
import kh.edu.niptict.room.database.Book;
import kh.edu.niptict.room.database.utils.DatabaseInitializer;

public class MainViewModel extends AndroidViewModel {
    public LiveData<List<Book>> books;
    private AppDatabase mDb;

    public MainViewModel(@NonNull Application application) {
        super(application);
        createDb();
//        books = mDb.bookModel().findBooksBorrowedByName("Mike");
    }

    public LiveData<List<Book>> getBorrowedBookByName(String name) {
        return mDb.bookModel().findBooksBorrowedByName(name);
    }

    public void createDb() {
        mDb = AppDatabase.getDatabaseBuilder(this.getApplication());

        // Populate it with initial data
        DatabaseInitializer.populateAsync(mDb);
    }
}
