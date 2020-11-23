package com.andairka.wsb.tota;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.andairka.wsb.tota.database.ExpensesDatabase;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExpensesDatabase db = Room.databaseBuilder(getApplicationContext(),
                ExpensesDatabase.class, "expense-database").build();
    }


    public void addIncomeButtonOnClickAction(View view) {
        Intent intent = new Intent(this, AddIncomeActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Dodajemy przychoda na głoda", Toast.LENGTH_LONG).show();
    }
}