package kh.edu.niptict.librarymangementroomdb.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;
import java.util.List;

import kh.edu.niptict.librarymangementroomdb.database.entity.Loan;
import kh.edu.niptict.librarymangementroomdb.database.entity.LoanWithUserAndBook;
import kh.edu.niptict.librarymangementroomdb.database.helper.DateConverter;

@Dao
@TypeConverters(DateConverter.class)
public interface LoanDao {

    @Query("SELECT * From Loan")
    LiveData<List<Loan>> findAllLoans();

    @Query("SELECT Loan.id, Book.title, User.name, Loan.startTime, Loan.endTime From Loan " +
            "INNER JOIN Book ON Loan.book_id = Book.id " +
            "INNER JOIN User ON Loan.user_id = User.id ")
    LiveData<List<LoanWithUserAndBook>> findAllWithUserAndBook();

    @Query("SELECT Loan.id, Book.title as title, User.name as name, Loan.startTime, Loan.endTime " +
            "FROM Book " +
            "INNER JOIN Loan ON Loan.book_id = Book.id " +
            "INNER JOIN User on User.id = Loan.user_id " +
            "WHERE User.name LIKE :userName " +
            "AND Loan.endTime > :after "
    )
    LiveData<List<LoanWithUserAndBook>> findLoansByNameAfter(String userName, Date after);

    @Insert()
    void insertLoan(Loan loan);

    @Query("DELETE FROM Loan")
    void deleteAll();
}
