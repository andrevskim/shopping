package com.example.shopping.db.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ProductEntity {
    @PrimaryKey(autoGenerate = true)
    public int pid;

    @ColumnInfo(name = "product")
    public String product;

    @ColumnInfo(name = "status")
    public String status;



}
