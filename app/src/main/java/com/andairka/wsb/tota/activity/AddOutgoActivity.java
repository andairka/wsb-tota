package com.andairka.wsb.tota.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.andairka.wsb.tota.R;

public class AddOutgoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_outgo);


    }

    public void addExpenseButtonOnClickAction(View view) {
        Toast.makeText(this, "dodałeś wydatek", Toast.LENGTH_LONG).show();
    }


    public void cancelButtonOnClickAction(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Anulowałeś czynność", Toast.LENGTH_LONG).show();
    }
}
