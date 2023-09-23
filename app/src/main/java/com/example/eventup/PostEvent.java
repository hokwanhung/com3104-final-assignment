package com.example.eventup;

public class PostEvent {
    private String postByID;
    private String title;
    private String date;
    private String time;
    private String description;
    private String district;
    private String address;
    private int quota;
    private int fee;

    public PostEvent(String postByID, String title, String date, String time, String description, String district, String address, int quota, int fee) {
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

    public void setPostByID(String postByID) {
        this.postByID = postByID;
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
}