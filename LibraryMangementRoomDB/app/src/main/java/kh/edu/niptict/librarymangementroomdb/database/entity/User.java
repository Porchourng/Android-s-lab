package kh.edu.niptict.librarymangementroomdb.database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import java.util.Date;

import kh.edu.niptict.librarymangementroomdb.database.helper.DateConverter;

@Entity
@TypeConverters(DateConverter.class)
public class User {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private long id;

    private String name;
    private char gender;
    private Date dob;

    public User(String name, char gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    @NonNull
    public long getId() {
        return id;
    }

    public void setId(@NonNull long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
