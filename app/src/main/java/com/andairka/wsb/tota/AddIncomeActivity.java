package com.andairka.wsb.tota;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.andairka.wsb.tota.database.DatabaseService;
import com.andairka.wsb.tota.database.ExpensesDatabase;
import com.andairka.wsb.tota.database.entities.Income;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddIncomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_income);

        ExpensesDatabase db = Room.databaseBuilder(getApplicationContext(),
                ExpensesDatabase.class, "expense-database").build();
    }

    public void addInButtonOnClickAction(View view) {
        DatabaseService databaseService = new DatabaseService(getApplicationContext());
        Income income = new Income();

        // TU
        TextView name = (TextView) findViewById(R.id.nazwaPrzychodu);
        income.name = name.getEditableText().toString();

        TextView amount = (TextView) findViewById(R.id.incomeValue);
        income.amount = Double.parseDouble(amount.getEditableText().toString());

        TextView date = (TextView) findViewById(R.id.incomeDate);
        try {
            income.date = new SimpleDateFormat("dd.MM.yyyy").parse(date.getEditableText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }


//        databaseService.getIncomeDao().insertAll(income);

        Toast.makeText(this, "dodałeś przychód "+income.name + income.amount + income.date, Toast.LENGTH_LONG).show();
    }

    public void cancelButtonOnClickAction(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Anulowałeś czynność", Toast.LENGTH_LONG).show();
    }
}
