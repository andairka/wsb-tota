package com.andairka.wsb.tota.database;

import android.content.Context;

import androidx.room.Room;

import com.andairka.wsb.tota.database.dao.ExpensesDao;
import com.andairka.wsb.tota.database.dao.IncomeDao;

public class DatabaseService {

    private ExpensesDatabase db;

    public DatabaseService(Context context) {
         db = Room.databaseBuilder(context,
                ExpensesDatabase.class, "expense-database").fallbackToDestructiveMigrationOnDowngrade()
                 .allowMainThreadQueries()
                 .fallbackToDestructiveMigration().build();
    }

    public ExpensesDatabase getDatabase() {
        return this.db;
    }

    public IncomeDao getIncomeDao() {
        return this.db.incomeDao();
    }

    public ExpensesDao getExpensesDao() {
        return this.db.expensesDao();
    }
}
