package kh.edu.niptict.librarymangementroomdb.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.NonNull;

import kh.edu.niptict.librarymangementroomdb.database.dao.BookDao;
import kh.edu.niptict.librarymangementroomdb.database.dao.UserDao;
import kh.edu.niptict.librarymangementroomdb.database.entity.Book;
import kh.edu.niptict.librarymangementroomdb.database.entity.User;

@Database(entities = {User.class, Book.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract UserDao userModel();

    public abstract BookDao bookModel();

   // public abstract LoanDao loanModel();

    public static AppDatabase getInMemoryDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.inMemoryDatabaseBuilder(context.getApplicationContext(),
                            AppDatabase.class)
                            // To simplify the codelab, allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                     //       .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    public static AppDatabase getDatabaseBuilder(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "librarydb.sqlite")
                   // .allowMainThreadQueries()
                    .addMigrations(MIGRATION_1_2)
                    .build();
        }
        return INSTANCE;
    }

    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE Book "
                    + " ADD COLUMN pub_year INTEGER");
        }
    };

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
