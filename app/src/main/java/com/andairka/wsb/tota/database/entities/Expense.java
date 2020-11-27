package com.andairka.wsb.tota.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class Expense {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "date")
    public Date date;

    @ColumnInfo(name = "amount")
    public double amount;

    @ColumnInfo(name = "category")
    public String category;
}
