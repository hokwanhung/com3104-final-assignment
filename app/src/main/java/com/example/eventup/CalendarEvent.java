package com.example.eventup;

import java.util.Map;

public class CalendarEvent {
    private String key;
    private String date;
    private String time;
    private String title;
    private String district;
    private String address;

    private Map<String, String> participants;

    public CalendarEvent() {
    }

    public CalendarEvent(String key, String date, String time, String title, String district, String address, Map<String, String> participants) {
        this.key = key;
        this.date = date;
        this.time = time;
        this.title = title;
        this.district = district;
        this.address = address;
        this.participants = participants;
    }

    public String getKey() {
        return key;
    }

    public String getTitle() { return title; }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getDistrict() { return district; }

    public String getAddress() {
        return address;
    }

    public Map<String, String> getParticipants() {
        return participants;
    }
}