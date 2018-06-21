package kh.edu.niptict.librarymangementroomdb.database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Book {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private long id;
    private String title;
    private String isbn;

    public Book(String title, String isbn) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
    }

    @NonNull
    public long getId() {
        return id;
    }

    public void setId(@NonNull long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
