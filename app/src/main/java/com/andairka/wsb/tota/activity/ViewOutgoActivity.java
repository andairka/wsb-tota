package com.andairka.wsb.tota.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.andairka.wsb.tota.R;
import com.andairka.wsb.tota.adapter.ExpenseArrayAdapter;
import com.andairka.wsb.tota.adapter.IncomeArrayAdapter;
import com.andairka.wsb.tota.database.DatabaseService;
import com.andairka.wsb.tota.database.entities.Expense;
import com.andairka.wsb.tota.database.entities.Income;

import java.util.List;

public class ViewOutgoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_outgo);


        DatabaseService databaseService = new DatabaseService(getApplicationContext());
        List<Expense> expenses = databaseService.getExpensesDao().getAll();

        ExpenseArrayAdapter expenseAdapter =  new ExpenseArrayAdapter(this, expenses);
        ListView listView = findViewById(R.id.expenseListView);
        listView.setAdapter(expenseAdapter);
    }

    public void backButtonOnClickAction(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Toast.makeText(this, "to był rzut oka na wydatki", Toast.LENGTH_LONG).show();

    }
}
