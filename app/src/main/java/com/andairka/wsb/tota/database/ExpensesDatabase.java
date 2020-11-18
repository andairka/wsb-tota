package com.andairka.wsb.tota.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.andairka.wsb.tota.database.converters.Converters;
import com.andairka.wsb.tota.database.dao.ExpensesDao;
import com.andairka.wsb.tota.database.entities.Expense;

@Database(entities = {Expense.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class ExpensesDatabase extends RoomDatabase {
    public abstract ExpensesDao expensesDao();
}
