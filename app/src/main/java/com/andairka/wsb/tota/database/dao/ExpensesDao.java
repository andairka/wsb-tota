package com.andairka.wsb.tota.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.andairka.wsb.tota.database.entities.Expense;

import java.util.List;

@Dao
public interface ExpensesDao {

    @Query("SELECT * FROM expense")
    List<Expense> getAll();

    @Query("SELECT * FROM expense WHERE category LIKE :category")
    Expense findByName(String category);

    @Insert
    void insertAll(Expense... expenses);

    @Delete
    void delete(Expense expense);
}
