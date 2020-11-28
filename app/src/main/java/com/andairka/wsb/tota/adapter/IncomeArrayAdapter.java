package com.andairka.wsb.tota.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.andairka.wsb.tota.R;
import com.andairka.wsb.tota.database.entities.Income;
import com.andairka.wsb.tota.utils.Utils;
import java.util.List;

/**
 * Income array adapter responsible for adapting income entities in view income list.
 * @author Adrianna Pater (andairka@wp.pl)
 */
public class IncomeArrayAdapter extends ArrayAdapter<Income> {

    public IncomeArrayAdapter(Context context, List<Income> incomes) {
        super(context, 0, incomes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Income income = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.income_item, parent, false);
        }
        // Lookup view for data population
        TextView incomeItemName = (TextView) convertView.findViewById(R.id.income_item_name);
        TextView incomeItemValue = (TextView) convertView.findViewById(R.id.income_item_value);
        // Populate the data into the template view using the data object
        incomeItemName.setText(income.name + "    " + Utils.parseDate(income.date));
        incomeItemValue.setText(String.valueOf(income.amount));
        // Return the completed view to render on screen
        return convertView;
    }
}

