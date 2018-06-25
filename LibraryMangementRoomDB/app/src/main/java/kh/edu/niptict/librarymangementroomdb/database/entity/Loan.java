package kh.edu.niptict.librarymangementroomdb.database.entity;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import java.util.Date;

import kh.edu.niptict.librarymangementroomdb.database.helper.DateConverter;

@Entity(foreignKeys = {
        @ForeignKey(entity = Book.class,
                parentColumns = "id",
                childColumns = "book_id"),

        @ForeignKey(entity = User.class,
                parentColumns = "id",
                childColumns = "user_id")})
@TypeConverters(DateConverter.class)
public class Loan {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public long id;

    public Date startTime;

    public Date endTime;

    @ColumnInfo(name="book_id")
    public long bookId;

    @ColumnInfo(name="user_id")
    public long userId;
}
