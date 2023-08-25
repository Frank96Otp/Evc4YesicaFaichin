package com.example.evc4_faichin_diaz_movidedb.db;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.evc4_faichin_diaz_movidedb.Model.DogEntity;

@Database(entities = {DogEntity.class} , version = 1)
public abstract class DogDatabase extends RoomDatabase {

    public abstract DogDao showDao();

    public static DogDatabase db;

    public static DogDatabase getInstance(  Context context){
        DogDatabase dbTemp = db;
        if(dbTemp == null){
            dbTemp = Room.databaseBuilder(context.getApplicationContext(), DogDatabase.class, "dog-database").build();
            db = dbTemp;
        }

        return  dbTemp;

    }
}
