package com.example.efmmobail;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class classe extends SQLiteOpenHelper {
    public classe(@Nullable Context context ) {
        super(context, "Name.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Gestion (id int primary key autoincrement, nom Text, tele int ,email Text,annee Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Gestion ");
        this.onCreate(db);
    }
    //ajouter
    public Boolean Ajoute(String n, int t, String e, String a){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("nom",n);
        cv.put("tele",t);
        cv.put("email",e);
        cv.put("annee",a);
        if(db.insert("Gestion",null,cv)==-1)return false;
        return true;
    }


    public ArrayList<HashMap <String,String>> Affiche(){
        SQLiteDatabase db=this.getReadableDatabase();
        ArrayList<HashMap <String,String>> list= new ArrayList<HashMap <String,String>>();
        HashMap <String,String> Stg;
        Cursor cr=db.rawQuery("select * from Gestion",null);
        cr.moveToFirst();
        while (!cr.isAfterLast()){
            Stg=new HashMap <String,String>();
            Stg.put("nom",cr.getString(1));
            Stg.put("tele",String.valueOf(cr.getInt(2)));
            Stg.put("email",cr.getString(3));
            Stg.put("annee",cr.getString(4));
            list.add(Stg);
            cr.moveToNext();
        }
        cr.close();
        return list;
    }
}
