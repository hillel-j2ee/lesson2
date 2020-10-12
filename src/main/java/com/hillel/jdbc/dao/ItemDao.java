package com.hillel.jdbc.dao;

import com.hillel.jdbc.model.Item;

import java.util.List;

public interface ItemDao {
	String SQL_FIND_ALL = "select * from " + Item.TABLE_NAME;
	String SQL_FIND_BY_ID = SQL_FIND_ALL + " where " + Item.ID_COLUMN + " = ?";
	String SQL_INSERT = "insert into " + Item.TABLE_NAME + " (" + Item.NAME_COLUMN + ", " + Item.WAREHOUSE_ID_COLUMN + ") values (?, ?)";
	String SQL_UPDATE = "update " + Item.TABLE_NAME + " set " + Item.NAME_COLUMN + " where " + Item.ID_COLUMN + " = ?";
	String SQL_DELETE = "delete from " + Item.TABLE_NAME + " where " + Item.ID_COLUMN + " = ?";
	
	List<Item> findAll();
	Item findById(Long id);
	void insert(Item item);
	void update(Item item);
	void delete(Item item);
}