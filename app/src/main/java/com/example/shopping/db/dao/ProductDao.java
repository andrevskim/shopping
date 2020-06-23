package com.example.shopping.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.shopping.db.entity.ProductEntity;

import java.util.List;

@Dao
public interface ProductDao {
    @Query("SELECT * FROM productentity")
    List<ProductEntity> getAll();

    @Insert
    void insertAll(ProductEntity... product);

    @Delete
    void delete(ProductEntity product);




}
