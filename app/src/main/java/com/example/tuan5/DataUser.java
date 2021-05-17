package com.example.tuan5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

public class DataUser extends SQLiteOpenHelper {
    public DataUser(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql= "CREATE TABLE user ( " +
                "id INTEGER PRIMARY KEY, " +
                "name TEXT NOT NULL)";
        db.execSQL(sql);

    }

    public void addUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values=  new ContentValues();
        values.put("id",user.getId());
        values.put("name",user.getName());

        db.insert("user",null,values);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
