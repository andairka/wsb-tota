package com.andairka.wsb.tota.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.andairka.wsb.tota.R;
import com.andairka.wsb.tota.database.DatabaseService;
import com.andairka.wsb.tota.database.entities.Income;
import com.andairka.wsb.tota.utils.Utils;

/**
 * Activity responsible for adding new Income.
 * @author Adrianna Pater (andairka@wp.pl)
 */
public class AddIncomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_income);
        TextView date = (TextView) findViewById(R.id.incomeDate);
        date.setText(Utils.getCurrentDate());
    }

    public void addInButtonOnClickAction(View view) {
        // Get database service.
        DatabaseService databaseService = new DatabaseService(getApplicationContext());

        // Get Income from view.
        Income income = this.getIncomeFromView();

        // Check if income is filled properly.
        if ( income.name != null && !income.name.isEmpty() && income.date != null && income.amount > 0 ) {
            databaseService.getIncomeDao().insertAll(income);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Dodałeś przychód"+income.name + income.amount + income.date, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Proszę wypełnić wszystkie wymagane pola.", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Handling action after Cancel button click.
     * @param view
     */
    public void cancelButtonOnClickAction(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Anulowałeś czynność", Toast.LENGTH_LONG).show();
    }

    /**
     * Method gets Income item from View.
     * @return Income object with values from view.
     */
    private Income getIncomeFromView() {
        Income income = new Income();
        TextView name = (TextView) findViewById(R.id.nazwaPrzychodu);
        income.name = name.getEditableText().toString();

        TextView amount = (TextView) findViewById(R.id.incomeValue);
        String amountString = amount.getEditableText().toString();
        if (amountString != null && !amountString.isEmpty()) {
            income.amount = Double.parseDouble(amountString);
        }

        TextView date = (TextView) findViewById(R.id.incomeDate);
        income.date = Utils.parseInputDate(date.getEditableText().toString());
        return income;
    }

}
