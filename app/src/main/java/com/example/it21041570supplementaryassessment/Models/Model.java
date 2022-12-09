package com.example.it21041570supplementaryassessment.Models;

public class Model {

    int id;
    String note;
    String date;
    String time;

    public Model(int id, String note, String date, String time) {
        this.id = id;
        this.note = note;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
