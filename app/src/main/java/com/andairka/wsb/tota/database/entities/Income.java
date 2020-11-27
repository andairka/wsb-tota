package com.andairka.wsb.tota.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class Income {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "date")
    public Date date;

    @ColumnInfo(name = "amount")
    public double amount;

    @ColumnInfo(name = "name")
    public String name;
}
