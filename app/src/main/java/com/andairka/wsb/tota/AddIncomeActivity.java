package com.andairka.wsb.tota;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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

    public void addInButtonOnClickAction(View view) {
        Toast.makeText(this, "dodałeś przychód", Toast.LENGTH_LONG).show();
    }

    public void cancelButtonOnClickAction(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Anulowałeś czynność", Toast.LENGTH_LONG).show();
    }
}
