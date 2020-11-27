package com.andairka.wsb.tota.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.andairka.wsb.tota.database.converters.Converters;
import com.andairka.wsb.tota.database.dao.ExpensesDao;
import com.andairka.wsb.tota.database.dao.IncomeDao;
import com.andairka.wsb.tota.database.entities.Expense;
import com.andairka.wsb.tota.database.entities.Income;

@Database(entities = {Expense.class, Income.class}, version = 2)
@TypeConverters({Converters.class})
public abstract class ExpensesDatabase extends RoomDatabase {
    public abstract ExpensesDao expensesDao();
    public abstract IncomeDao incomeDao();
}
