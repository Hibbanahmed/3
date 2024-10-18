package com.example.trustpassplus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class PasswordAdapter extends ArrayAdapter<Password> {

    public PasswordAdapter(Context context, List<Password> passwords) {
        super(context, 0, passwords);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Password password = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.password_item, parent, false);
        }

        TextView titleTextView = convertView.findViewById(R.id.titleTextView);
        TextView usernameTextView = convertView.findViewById(R.id.usernameTextView);

        titleTextView.setText(password.getTitle());
        usernameTextView.setText(password.getUsername());

        return convertView;
    }
}