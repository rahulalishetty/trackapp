package com.example.user.trackapp2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

//import android.database.sqlite.SQLiteDatabase.CursorFactory;
//import android.view.View.OnClickListener;

public class MyDBHandler extends SQLiteOpenHelper {

    static final int DATABASE_VERSION = 1;
    static final String DATABASE_NAME = "logindatabase.db";
    static final String TABLE_LOGIN_NAME = "logindatabase";

    static final String COLUMN_FULLNAME = "fullname";
    static final String COLUMN_LOGID = "loginid";
    static final String COLUMN_PASSWORD = "password";

    static final String TABLE_ACTIVITY_NAME = "activitytable";
    static final String COLUMN_ACTIVITY_NAME = "alarmactivityname";
    static final String COLUMN_TIME = "time";

    public MyDBHandler(Context c) {
        super(c, DATABASE_NAME, null, 2);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_DATA = "create table " + TABLE_LOGIN_NAME + "(" + COLUMN_FULLNAME + " text," + COLUMN_LOGID + " integer primary key," + COLUMN_PASSWORD + " text);";
        //String CREATE_ACTIVITY_TABLE = "create table " + TABLE_ACTIVITY_NAME + "("+COLUMN_ACTIVITY_NAME + " text," + COLUMN_TIME + " text);";
        db.execSQL(CREATE_DATA);
       //// db.execSQL(CREATE_ACTIVITY_TABLE);
       // db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
        // TODO Auto-generated method stub
       // if(arg1==1)
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOGIN_NAME);
        String CREATE_ACTIVITY_TABLE = "create table " + TABLE_ACTIVITY_NAME + "("+COLUMN_ACTIVITY_NAME + " text," + COLUMN_TIME + " text);";
        db.execSQL(CREATE_ACTIVITY_TABLE);
       // db.execSQL("DROP TABLE IF EXISTS " + TABLE_ACTIVITY_NAME);
        onCreate(db);
    }


    public void addData(DetailsLogin dl) {

        ContentValues v = new ContentValues();
        v.put(COLUMN_FULLNAME, dl.getFullName());
        v.put(COLUMN_LOGID, dl.loginid);
        v.put(COLUMN_PASSWORD, dl.password);

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_LOGIN_NAME, null, v);
        db.close();

    }

    boolean findid(Long fid, String text_password) {

        String query = "select * from " + TABLE_LOGIN_NAME + " where " + COLUMN_LOGID + "=" + fid;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(query, null);

        if (c.moveToNext()) {
            String passcheck = c.getString(2);
            if (passcheck.equals(text_password))
                return true;
        }

        return false;
    }
    String findfullname(Long fid){
        String query = "select "+COLUMN_FULLNAME+" from " + TABLE_LOGIN_NAME + " where " + COLUMN_LOGID + "=" + fid;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(query, null);
        if(c.moveToNext())
            return c.getString(0);
        else return "User";
    }

    public void addActivityName(DetailsAlarm da) {
        ContentValues v = new ContentValues();
        //v.put(COLUMN_FULLNAME,da.getFullname());
        v.put(COLUMN_ACTIVITY_NAME, da.getAlarm_activity_name());
        v.put(COLUMN_TIME, da.getTime());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_ACTIVITY_NAME, null, v);
        db.close();
    }

    public ArrayList<SingleRow> getColumnActivityName() {
        String query = "select * from " + TABLE_ACTIVITY_NAME + ";";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(query, null);
        ArrayList<SingleRow> arrayList = new ArrayList<SingleRow>();
        while (c.moveToNext()) {
            arrayList.add(new SingleRow(c.getString(0), c.getString(1)));
        }
        db.close();
        //Log.d("AL s","log");
        return arrayList;
    }


}
