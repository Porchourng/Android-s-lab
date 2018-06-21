package kh.edu.niptict.librarymangementroomdb.database.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;

import kh.edu.niptict.librarymangementroomdb.database.helper.DateConverter;

public class LoanWithUserAndBook {
    public String id;

    @ColumnInfo(name="title")
    public String bookTitle;

    @ColumnInfo(name="name")
    public String userName;

    @TypeConverters(DateConverter.class)
    public Date startTime;

    @TypeConverters(DateConverter.class)
    public Date endTime;
}
