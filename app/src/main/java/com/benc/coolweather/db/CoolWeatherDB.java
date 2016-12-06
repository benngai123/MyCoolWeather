package com.benc.coolweather.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;

import com.benc.coolweather.model.City;
import com.benc.coolweather.model.County;
import com.benc.coolweather.model.Province;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kamyuenngai on 2016/12/6.
 */

public class CoolWeatherDB {
    private static CoolWeatherDB coolWeatherDB;
    private SQLiteDatabase db;

    private CoolWeatherDB(Context context) {
        CoolWeatherOpenHelper dbHelper = new CoolWeatherOpenHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    //获取 CoolWeatherDB 的实例
    public synchronized static CoolWeatherDB getInstance(Context context){
        if (coolWeatherDB == null){
            coolWeatherDB = new CoolWeatherDB(context);
        }
        return coolWeatherDB;
    }


    //插入 Province 数据
    public void saveProvince (Province province){
        if (province != null){
            ContentValues values = new ContentValues();
            values.put("province_name",province.getProvinceName());
            values.put("province_code",province.getProvinceCode());
            db.insert("Province",null,values);
        }
    }

    //从数据库读取全国所有的省份信息
    public List<Province> loadProvinces(){
        List<Province> list = new ArrayList<>();
        Cursor cursor = db.query("Province",null,null,null,null,null,null);
        while (cursor.moveToNext()){
            Province province = new Province();
            province.setId(cursor.getInt(cursor.getColumnIndex("id")));
            province.setProvinceName(cursor.getString(cursor.getColumnIndex("province_name")));
            province.setProvinceCode(cursor.getString(cursor.getColumnIndex("province_code")));
            list.add(province);
        }
        if (cursor != null){
            cursor.close();
        }
        return list;
    }
    //插入 City 数据
    public void saveCity (City city){
        if (city != null){
            ContentValues values = new ContentValues();
            values.put("city_name",city.getCityName());
            values.put("city_code",city.getCityCode());
            db.insert("City",null,values);
        }
    }

    //从数据库读取全国所有的城市信息
    public List<City> loadCities(){
        List<City> list = new ArrayList<>();
        Cursor cursor = db.query("City",null,null,null,null,null,null);
        while (cursor.moveToNext()){
            City city = new City();
            city.setId(cursor.getInt(cursor.getColumnIndex("id")));
            city.setCityName(cursor.getString(cursor.getColumnIndex("city_name")));
            city.setCityCode(cursor.getString(cursor.getColumnIndex("city_code")));
            list.add(city);
        }
        if (cursor != null){
            cursor.close();
        }
        return list;
    }
    //插入 County 数据
    public void saveCounty (County county){
        if (county != null){
            ContentValues values = new ContentValues();
            values.put("county_name",county.getCountyName());
            values.put("county_code",county.getCountyCode());
            db.insert("County",null,values);
        }
    }

    //从数据库读取全国所有的县信息
    public List<County> loadCounties(){
        List<County> list = new ArrayList<>();
        Cursor cursor = db.query("County",null,null,null,null,null,null);
        while (cursor.moveToNext()){
            County county = new County();
            county.setId(cursor.getInt(cursor.getColumnIndex("id")));
            county.setCountyName(cursor.getString(cursor.getColumnIndex("county_name")));
            county.setCountyCode(cursor.getString(cursor.getColumnIndex("county_code")));
            list.add(county);
        }
        if (cursor != null){
            cursor.close();
        }
        return list;
    }
}
