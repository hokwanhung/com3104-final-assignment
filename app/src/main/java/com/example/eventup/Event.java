package com.example.eventup;

import android.os.Parcel;
import android.os.Parcelable;

public class Event implements Parcelable {
    private String key;
    private String postByID;
    private String title;
    private String date;
    private String time;
    private String description;
    private String district;
    private String address;
    private int quota;
    private int fee;

    public Event(String key, String postByID, String title, String date, String time, String description, String district, String address, int quota, int fee) {
        this.key = key;
        this.postByID = postByID;
        this.title = title;
        this.date = date;
        this.time = time;
        this.description = description;
        this.district = district;
        this.address = address;
        this.quota = quota;
        this.fee = fee;
    }

    // Getter methods for each field

    protected Event(Parcel in) {
        key = in.readString();
        postByID = in.readString();
        title = in.readString();
        date = in.readString();
        time = in.readString();
        description = in.readString();
        district = in.readString();
        address = in.readString();
        quota = in.readInt();
        fee = in.readInt();
    }

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

    public String getKey() {
        return key;
    }

    public String getPostByID() {
        return postByID;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public String getDistrict() {
        return district;
    }

    public String getAddress() {
        return address;
    }

    public int getQuota() {
        return quota;
    }

    public int getFee() {
        return fee;
    }

    //setter
    public void setKey(String key) {
        this.key = key;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(key);
        dest.writeString(postByID);
        dest.writeString(title);
        dest.writeString(date);
        dest.writeString(time);
        dest.writeString(description);
        dest.writeString(district);
        dest.writeString(address);
        dest.writeInt(quota);
        dest.writeInt(fee);
    }
}