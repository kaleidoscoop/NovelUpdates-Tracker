package com.example.project;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class DatabaseAccess {

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor n = null;

//    private constructor
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

//    return single instance of database
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

//    to open database
    public void open() {
        this.db = openHelper.getWritableDatabase();
    }

//    close database connection
    public void close() {
        if (db != null) {
            this.db.close();
        }
    }

//    create method to query to result
    public ArrayList<NovelData> returnData(int novelID) {
        ArrayList<NovelData> list = new ArrayList<>();

        n = db.rawQuery("select * from NovelData where ID = novelID", new String[]{});
        while (n.moveToNext()) {

        }
        return list;
    }

}
