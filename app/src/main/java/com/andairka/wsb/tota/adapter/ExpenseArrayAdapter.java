package com.andairka.wsb.tota.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.andairka.wsb.tota.R;
import com.andairka.wsb.tota.database.entities.Expense;
import com.andairka.wsb.tota.database.entities.Income;
import com.andairka.wsb.tota.utils.Utils;

import java.util.List;

public class ExpenseArrayAdapter extends ArrayAdapter<Expense> {


    public ExpenseArrayAdapter(Context context, List<Expense> expenses) {
        super(context, 0, expenses);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Expense expense = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.expense_item, parent, false);
        }
        // Lookup view for data population
        TextView expenseItemCategory = (TextView) convertView.findViewById(R.id.expense_item_category);
        TextView expenseItemAmount = (TextView) convertView.findViewById(R.id.expense_item_amount);
        // Populate the data into the template view using the data object
        expenseItemCategory.setText(expense.category + "    " + Utils.parseDate(expense.date));
        expenseItemAmount.setText(String.valueOf(expense.amount));
        // Return the completed view to render on screen
        return convertView;
    }
}

