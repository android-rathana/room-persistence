package com.example.ratha.roomdemo.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by ratha on 2/2/2018.
 */
@Entity(indices = {@Index(value = "name",unique = true)})
public class Category {

    @PrimaryKey(autoGenerate = true)
    public int uid;
    public String name;
    public String desc;

}
