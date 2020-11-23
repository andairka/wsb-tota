package com.andairka.wsb.tota;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.andairka.wsb.tota.database.ExpensesDatabase;

public class AddIncomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_income);

        ExpensesDatabase db = Room.databaseBuilder(getApplicationContext(),
                ExpensesDatabase.class, "expense-database").build();
    }
}
