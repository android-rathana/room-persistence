package com.example.ratha.roomdemo.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.ratha.roomdemo.entity.User;

import java.util.List;

/**
 * Created by ratha on 2/1/2018.
 */

@Dao
public abstract class UserDao {

    @Query("SELECT * FROM users order by uid asc")
    public abstract List<User> getAll();

    @Insert
    public abstract void add(User ... users);
}
