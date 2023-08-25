package com.example.evc4_faichin_diaz_movidedb.Model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "dog")
public class DogEntity {

    @PrimaryKey(autoGenerate = true)
    private String id;

    @ColumnInfo(name = "imagen")
    private String img;
}
