package kh.edu.niptict.librarymangementroomdb.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import kh.edu.niptict.librarymangementroomdb.database.entity.Book;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;

//Dao -> Data Access Object
@Dao
public interface BookDao {

    @Query("Select * from Book")
    public List<Book> getAllBookNoLiveData();

    @Query("Select * from Book")
    public LiveData<List<Book>> getAllBook();

    @Insert(onConflict = IGNORE)
    public void insertNewBook(Book book);

    @Insert(onConflict = IGNORE)
    public void insertMultipleBook(Book... books);
}
