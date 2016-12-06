package com.benc.coolweather.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kamyuenngai on 2016/12/6.
 */

public class CoolWeatherOpenHelper extends SQLiteOpenHelper {

    /**
     * Prince，City，County 建表语句
     */
    private static final String CREATE_PRPVINCE = "create table Province (id integer primary key autoincrement,province_name text,province_code text";
    private static final String CREATE_CITY = "create table City (id integer primary key autoincrement,city_name text,city_code text";
    private static final String CREATE_COUNTY = "create table County (id integer primary key autoincrement,county_name text,county_code text";
    private static final String DB_NAME = "COOL_WEATHER";//数据库名
    private static final int VERSION = 1;//数据库版本

    public CoolWeatherOpenHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PRPVINCE);
        db.execSQL(CREATE_CITY);
        db.execSQL(CREATE_COUNTY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
