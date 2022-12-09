package com.example.it21041570supplementaryassessment.Database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.it21041570supplementaryassessment.Models.Model;

import java.util.ArrayList;


public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(@Nullable Context context) {
        super(context, Constants.DB_NAME,null, Constants.DB_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Constants.CREATE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+ Constants.TABLE_NAME);
        onCreate(db);

    }

    //insert infomation

    public long insertInfo(String Note, String date, String time) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Constants.NOTE, Note);
        values.put(Constants.DATE, date);
        values.put(Constants.TIME, time);

        long id =  db.insert(Constants.TABLE_NAME, null, values);
        db.close();
        return id;

    }

    public ArrayList<Model> getAllData(String orderBy){

        ArrayList<Model> arrayList = new ArrayList<>();

        //query for select all info in databse
        String selectQuery = "SELECT * FROM " + Constants.TABLE_NAME + " ORDER BY " + orderBy;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        //select all info from databes new gte the data from column
        if(cursor.moveToNext()){

            do{
                Model model = new Model(
                        Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3)
                );
                System.out.println("ALL DATA OUTPUT" + model);
                arrayList.add(model);
            } while(cursor.moveToNext());
        }

        db.close();

        return arrayList;
    }

    //update infomation

    public void updateInfo(String id, String note, String date, String time) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Constants.NOTE, note);
        values.put(Constants.DATE, date);
        values.put(Constants.TIME, time);

        db.update(Constants.TABLE_NAME, values, Constants.ID + " = ?", new String[]{id});
        db.close();

    }


    //delete informatin

    public void deleteInfo(String id){

        SQLiteDatabase db = getWritableDatabase();
        db.delete(Constants.TABLE_NAME, Constants.ID + " = ? ", new String[]{id});
        db.close();

    }

}
