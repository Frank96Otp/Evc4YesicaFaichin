package com.example.evc4_faichin_diaz_movidedb.db;

import androidx.room.Insert;
import androidx.room.Query;

import com.example.evc4_faichin_diaz_movidedb.Model.DogEntity;

import java.util.List;

public interface DogDao {

    @Insert
    public  void addDog(DogEntity dog);

    @Query("SELECT * FROM dog")
    public List<DogEntity> getAll();
}
