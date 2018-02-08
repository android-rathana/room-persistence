package com.example.ratha.roomdemo.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.ratha.roomdemo.entity.Category;
import com.example.ratha.roomdemo.entity.User;

import java.util.List;

/**
 * Created by ratha on 2/1/2018.
 */

@Dao
public abstract class CategoryDao {

    @Query("SELECT * FROM category ORDER BY uid desc")
    public abstract List<Category> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void add(Category... categories);


}
