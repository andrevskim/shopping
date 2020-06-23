package com.example.shopping.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.shopping.db.dao.ProductDao;
import com.example.shopping.db.entity.ProductEntity;
@Database(entities = {ProductEntity.class}, version = 2)
public abstract class AppDB extends RoomDatabase {
    public abstract ProductDao productDao();

    private static AppDB instance;
    public static final String DATABASE_NAME = "product-db";

    public static AppDB getInstance(final Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDB.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}


