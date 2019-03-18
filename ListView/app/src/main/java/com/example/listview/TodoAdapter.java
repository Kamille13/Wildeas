package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class TodoAdapter extends ArrayAdapter<Todo> {

    public TodoAdapter(Context context, List<Todo> menu) {
        super(context, 0, menu);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Todo item =getItem(position);

        if (null == convertView) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_menu, parent, false);
            TextView textDescription = convertView.findViewById(R.id.textDescription);
            TextView textPrice = convertView.findViewById(R.id.textDate);

            textDescription.setText(((Todo) item).getDescription());
            textPrice.setText(((Todo) item).getDate());
        }
        return convertView;
    }
}
