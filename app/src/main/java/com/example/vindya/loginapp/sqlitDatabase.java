package com.example.vindya.loginapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class sqlitDatabase extends SQLiteOpenHelper {

    private static final String DB_NAME = "SqDb";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "Users";
    private static final String NAME = "user_name";
    private static final String Emai_Id = "email";
    private static final String PHNO = "ph_no";
    private static final String PASS_WRD = "password1";
    private static final String CONFM_PASS = "password2";
    SQLiteDatabase db;

    private static final String Quiry = "CREATE TABLE "+TABLE_NAME+"(" + NAME + " VARCHAR," + Emai_Id + " VARCHAR," + PHNO + " VARCHAR," + PASS_WRD + " VARCHAR," + CONFM_PASS + " VARCHAR)";

    public sqlitDatabase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Quiry);
        //this.db = db;
    }

    public void insertContact(information C) {
        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, C.getName());
        contentValues.put(Emai_Id, C.getEmailid());
        contentValues.put(PHNO, C.getPhno());
        contentValues.put(PASS_WRD, C.getPassword());
        contentValues.put(CONFM_PASS, C.getConfirmpassword());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

    public String ValidateData(String luname)
    {
        String a,b;
        db=this.getReadableDatabase();
        String qury="select user_name,password1 from "+TABLE_NAME;
        Cursor cursor=db.rawQuery(qury,null);
        b="not found";
        if(cursor.moveToFirst())
        {
            a=cursor.getString(0);

            do
            {

                if (luname.equals(a)) {
                    b = cursor.getString(1);
                    break;

                }
            }
            while (cursor.moveToNext());
        }
        return b;




    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        String quiry="DROP TABLE IF EXISTS"+TABLE_NAME;
        db.execSQL(quiry);
        this.onCreate(db);
    }

}

