package kh.edu.niptict.librarymangementroomdb.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import java.util.List;

import kh.edu.niptict.librarymangementroomdb.database.entity.User;
import kh.edu.niptict.librarymangementroomdb.database.helper.DateConverter;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;

@Dao
@TypeConverters(DateConverter.class)
public interface UserDao {

    @Query("Select * from User")
    public LiveData<List<User>> getAllUser();

    @Insert(onConflict = IGNORE)
    public void insertNewUser(User user);
}
