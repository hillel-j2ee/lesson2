package com.hillel.jdbc.dao;

import com.hillel.jdbc.model.Book;
import com.hillel.jdbc.model.Item;

import java.util.List;

public interface BookDao {
	String SQL_FIND_ALL = String.format("SELECT * FROM %s", Book.TABLE_TITLE);
	String SQL_FIND_BY_ID = String.format("SELECT * FROM %s WHERE %s = ?", Book.TABLE_TITLE, Book.ID_COLUMN);
	String SQL_INSERT = String.format("INSERT INTO %s (%s, %s, %s) VALUES (?, ?, ?)", Book.TABLE_TITLE, Book.NAME_COLUMN, Book.AUTHOR_COLUMN, Book.GENRE_COLUMN);
	String SQL_DELETE = String.format("DELETE FROM %s WHERE %s = ?", Book.TABLE_TITLE, Book.ID_COLUMN);

	String SQL_UPDATE_NAME = String.format("UPDATE %s SET %s = ? WHERE %s = ?", Book.TABLE_TITLE, Book.NAME_COLUMN, Book.ID_COLUMN);
	String SQL_UPDATE_AUTHOR = String.format("UPDATE %s SET %s = ? WHERE %s = ?", Book.TABLE_TITLE, Book.AUTHOR_COLUMN, Book.ID_COLUMN);
	String SQL_UPDATE_GENRE = String.format("UPDATE %s SET %s = ? WHERE %s = ?", Book.TABLE_TITLE, Book.GENRE_COLUMN, Book.ID_COLUMN);
	
	List<Book> findAll();
	Book findById(Long id);
	void insert(Book book);
	void updateName(Book book);
	void updateAuthor(Book book);
	void updateGenre(Book book);
	void delete(Book book);
}