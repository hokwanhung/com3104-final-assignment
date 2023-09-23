package com.example.eventup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CalendarEventAdapter extends RecyclerView.Adapter<CalendarEventAdapter.ViewHolder> {
    private List<CalendarEvent> calendarEventList;

    public CalendarEventAdapter(List<CalendarEvent> calendarEventList) {
        this.calendarEventList = calendarEventList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CalendarEvent calendarEvent = calendarEventList.get(position);
        holder.eventTitle.setText(calendarEvent.getTitle());
        holder.eventDateTime.setText(calendarEvent.getDate() + " " + calendarEvent.getTime());
        holder.eventAddress.setText(calendarEvent.getAddress());
        holder.eventDistrict.setText(calendarEvent.getDistrict());

    }

    @Override
    public int getItemCount() {
        return calendarEventList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView eventTitle, eventDateTime, eventAddress, eventDistrict;

        ViewHolder(View itemView) {
            super(itemView);
            eventTitle = itemView.findViewById(R.id.eventTitle);
            eventDateTime = itemView.findViewById(R.id.eventDateTime);
            eventAddress = itemView.findViewById(R.id.eventAddress);
            eventDistrict = itemView.findViewById(R.id.eventDistrict);

        }
    }

}
