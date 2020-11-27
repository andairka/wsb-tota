package com.andairka.wsb.tota.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.andairka.wsb.tota.R;
import com.andairka.wsb.tota.adapter.IncomeArrayAdapter;
import com.andairka.wsb.tota.database.DatabaseService;
import com.andairka.wsb.tota.database.entities.Income;

import java.util.ArrayList;
import java.util.List;

public class ViewIncomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_income);


        DatabaseService databaseService = new DatabaseService(getApplicationContext());
        List<Income> incomes = databaseService.getIncomeDao().getAll();


        IncomeArrayAdapter incomeAdapter =  new IncomeArrayAdapter(this, incomes);
        ListView listView = findViewById(R.id.incomeListView);
        listView.setAdapter(incomeAdapter);

    }

    public void backButtonOnClickAction(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Toast.makeText(this, "to był rzut oka na przychody", Toast.LENGTH_LONG).show();

    }
}
