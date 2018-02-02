package com.example.ratha.roomdemo.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.ratha.roomdemo.data.dao.CategoryDao;
import com.example.ratha.roomdemo.data.dao.UserDao;
import com.example.ratha.roomdemo.entity.Category;
import com.example.ratha.roomdemo.entity.User;

/**
 * Created by ratha on 2/1/2018.
 */
@Database(entities = {User.class, Category.class},version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract CategoryDao categoryDao();

    public static AppDatabase getInstance(Context context){
        return Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class,"test_db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }
}
