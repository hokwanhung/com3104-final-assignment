package com.example.eventup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EventAdapter extends ArrayAdapter<Event> {
    public EventAdapter(Context context, ArrayList<Event> events) {
        super(context, 0, events);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Event event = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_event, parent, false);
        }

        TextView tvTitle = convertView.findViewById(R.id.tvTitle);
        TextView tvDate = convertView.findViewById(R.id.tvDate);
        TextView tvDistrict = convertView.findViewById(R.id.tvDistrict);

        tvTitle.setText(event.getTitle());
        tvDate.setText(event.getDate() + " " + event.getTime());
        tvDistrict.setText(event.getDistrict());

        return convertView;
    }
}