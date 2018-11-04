package com.example.user.paperflyv0;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class Pending_Pickup_Database_m extends SQLiteOpenHelper {
    public Pending_Pickup_Database_m(@Nullable Context context) {
        super(context, "Pending_picks_manager.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String tableEmp="create table pen_manager(merchant_name text,executive_name text,assigned text,picked text,received text,unique(merchant_name,executive_name,assigned,picked,received))";

        sqLiteDatabase.execSQL(tableEmp);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void insertData(String merchant_name,String executive_name, String assigned,String picked,String received)

    {

        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();

        ContentValues values=new ContentValues();

        values.put("merchant_name",merchant_name);

        values.put("executive_name",executive_name);

        values.put("assigned",assigned);

        values.put("picked",picked);

        values.put("received",received);

        sqLiteDatabase.insert("pen_manager",null,values);

    }

    public Cursor getAllData(SQLiteDatabase db)
    {
        String[] columns = {"merchant_name","executive_name","assigned","picked","received"};
        return db.query("pen_manager",columns,null,null,null,null,null);
    }
}
