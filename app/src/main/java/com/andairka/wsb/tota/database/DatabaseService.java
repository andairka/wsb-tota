package com.andairka.wsb.tota.database;

import android.content.Context;

import androidx.room.Room;

import com.andairka.wsb.tota.database.dao.ExpensesDao;
import com.andairka.wsb.tota.database.dao.IncomeDao;

/**
 * Database service. Responsible for returning proper Data Access Object for data manipulation.
 * @author Adrianna Pater (andairka@wp.pl)
 */
public class DatabaseService {

    private ExpensesDatabase db;

    public DatabaseService(Context context) {
         db = Room.databaseBuilder(context,
                ExpensesDatabase.class, "expense-database").fallbackToDestructiveMigrationOnDowngrade()
                 .allowMainThreadQueries()
                 .fallbackToDestructiveMigration().build();
    }

    /**
     * Expense database - getter.
     * @return Expense database.
     */
    public ExpensesDatabase getDatabase() {
        return this.db;
    }

    /**
     * Income DAO
     * @return Income Data Access Object
     */
    public IncomeDao getIncomeDao() {
        return this.db.incomeDao();
    }

    /**
     * Expense DAO
     * @return Expense Data Access Object
     */
    public ExpensesDao getExpensesDao() {
        return this.db.expensesDao();
    }
}
