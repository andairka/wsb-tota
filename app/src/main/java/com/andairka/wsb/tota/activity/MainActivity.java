package com.andairka.wsb.tota.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.andairka.wsb.tota.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void addIncomeButtonOnClickAction(View view) {
        Intent intent = new Intent(this, AddIncomeActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Dodajemy przychoda na głoda", Toast.LENGTH_LONG).show();
    }

    public void addOutgoButtonOnClickAction(View view) {
        Intent intent = new Intent(this, AddOutgoActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Wydaliśmy na głoda", Toast.LENGTH_LONG).show();
    }

    public void viewIncomeButtonOnClickAction(View view) {
        Intent intent = new Intent(this, ViewIncomeActivty.class);
        startActivity(intent);
        Toast.makeText(this, "Ile mamy przychodów", Toast.LENGTH_LONG).show();
    }

    public void ViewOutgoButtonOnClickAction(View view) {
        Intent intent = new Intent(this, ViewOutgoActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Ile mamy wydatków", Toast.LENGTH_LONG).show();
    }

    public void closeButtonOnClickAction(View view) {
        Toast.makeText(this, "Baj Baj", Toast.LENGTH_LONG).show();
    }

}