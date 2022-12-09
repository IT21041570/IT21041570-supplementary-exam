package com.example.it21041570supplementaryassessment.Database;

public class Constants {

    //db name
    public static final String DB_NAME = "Notes_INFO_DB.db";
    //db version
    public static final int DB_VERSION = 1;
    //db table
    public static final String TABLE_NAME = "Notes";
    //table column
    public static final String ID = "ID";
    public static final String NOTE = "note";
    public static final String DATE = "date";
    public static final String TIME = "time";

    //CREATE QUERY for table
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + NOTE + " TEXT,"
            + DATE + " TEXT,"
            + TIME + " TEXT"
            + ");";



}
