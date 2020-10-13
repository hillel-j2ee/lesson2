package com.hillel.jdbc.dao;

import com.hillel.jdbc.model.KryvorotenkosShop;

import java.util.List;

public interface KryvorotenkosShopDao {
    String SQL_FIND_ALL = "select * from " + KryvorotenkosShop.TABLE_NAME;
    String SQL_FIND_BY_ID = SQL_FIND_ALL + " where " + KryvorotenkosShop.ID_COLUMN + " = ?";
    String SQL_INSERT = "insert into " + KryvorotenkosShop.TABLE_NAME + " (" + KryvorotenkosShop.ADDRESS_COLUMN + ") values (?)";
    String SQL_UPDATE = "update " + KryvorotenkosShop.TABLE_NAME + " set " + KryvorotenkosShop.ADDRESS_COLUMN + " = ? where " + KryvorotenkosShop.ID_COLUMN + " = ?";
    String SQL_DELETE = "delete from " + KryvorotenkosShop.TABLE_NAME + " where " + KryvorotenkosShop.ID_COLUMN + " = ?";

    List<KryvorotenkosShop> findAll();
    KryvorotenkosShop findById(Long id);
    void insert(KryvorotenkosShop item);
    void update(KryvorotenkosShop item);
    void delete(KryvorotenkosShop item);
}
