package com.andairka.wsb.tota;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;

import com.andairka.wsb.tota.database.ExpensesDatabase;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExpensesDatabase db = Room.databaseBuilder(getApplicationContext(),
                ExpensesDatabase.class, "expense-database").build();

    }
}