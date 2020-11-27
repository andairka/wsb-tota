package com.andairka.wsb.tota.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.andairka.wsb.tota.database.entities.Expense;
import com.andairka.wsb.tota.database.entities.Income;

import java.util.List;

@Dao
public interface IncomeDao {

    @Query("SELECT * FROM income")
    List<Income> getAll();

    @Query("SELECT * FROM income WHERE name LIKE :name")
    Income findByName(String name);

    @Query("SELECT sum(amount) FROM income")
    double sumAll();

    @Insert
    void insertAll(Income... incomes);

    @Delete
    void delete(Income income);
}
