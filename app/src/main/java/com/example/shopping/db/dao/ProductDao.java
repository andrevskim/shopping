package com.example.shopping.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.shopping.db.entity.ProductEntity;

import java.util.List;

@Dao
public interface ProductDao {
    @Query("SELECT * FROM productentity WHERE status='Активен'")
    List<ProductEntity> getAll();

    @Query("SELECT pid, product,status FROM productentity WHERE status='Пасивен'")
    List<ProductEntity> getPassive();

    @Query("DELETE FROM productentity WHERE status= 'Пасивен'")
    void deletePassive();

    @Insert
    long[] insertAll(ProductEntity... product);

    @Delete
    void delete(ProductEntity product);
    @Update
    void update(ProductEntity product);












}
