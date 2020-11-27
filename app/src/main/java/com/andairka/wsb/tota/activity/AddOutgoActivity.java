package com.andairka.wsb.tota.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.andairka.wsb.tota.R;
import com.andairka.wsb.tota.database.DatabaseService;
import com.andairka.wsb.tota.database.entities.Expense;
import com.andairka.wsb.tota.utils.Utils;

public class AddOutgoActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {

    final String[] categories = { "Codzienne", "Elektronika", "Rozrywka", "Na mieście", "Rachunki", "Other"};
    String spinnerSelected = categories[0];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_outgo);
        TextView date = (TextView) findViewById(R.id.expenseDate);
        date.setText(Utils.getCurrentDate());

        Spinner spin = (Spinner) findViewById(R.id.categoryExpenseSpinner);
        spin.setOnItemSelectedListener(this);
        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item, categories);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);
    }

    public void addExpenseButtonOnClickAction(View view) {
        // Get database service.
        DatabaseService databaseService = new DatabaseService(getApplicationContext());

        // Get Income from view.
        Expense expense = this.getExpenseFromView();

        if ( expense.category != null && !expense.category.isEmpty() && expense.date != null && expense.amount > 0 ) {
            databaseService.getExpensesDao().insertAll(expense);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Dodałeś wydatek"+expense.category + expense.amount + expense.date, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Proszę wypełnić wszystkie wymagane pola.", Toast.LENGTH_LONG).show();
        }
    }


    public void cancelButtonOnClickAction(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Anulowałeś czynność", Toast.LENGTH_LONG).show();
    }

    private Expense getExpenseFromView() {
        Expense expense = new Expense();
        expense.category = this.spinnerSelected;
        TextView amount = (TextView) findViewById(R.id.expenseValue);
        String amountString = amount.getEditableText().toString();
        if (amountString != null && !amountString.isEmpty()) {
            expense.amount = Double.parseDouble(amountString);
        }

        TextView date = (TextView) findViewById(R.id.expenseDate);
        expense.date = Utils.parseInputDate(date.getEditableText().toString());
        return expense;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        this.spinnerSelected = categories[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
