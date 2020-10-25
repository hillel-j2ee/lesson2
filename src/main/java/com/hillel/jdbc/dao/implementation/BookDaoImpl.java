package com.hillel.jdbc.dao.implementation;

import com.hillel.jdbc.dao.BookDao;
import com.hillel.jdbc.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookDaoImpl implements BookDao {
	@Autowired
	private DataSource dataSource;

	@Override
	public List<Book> findAll() {
		List<Book> result = new ArrayList<>();
		try(Connection connection = dataSource.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Book book = new Book.Builder()
						.withId(resultSet.getLong(Book.ID_COLUMN))
						.withName(resultSet.getString(Book.NAME_COLUMN))
						.withAuthor(resultSet.getString(Book.AUTHOR_COLUMN))
						.withGenre(resultSet.getString(Book.GENRE_COLUMN))
						.build();
				result.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Book findById(Long id) {
		Book book = null;
		try(Connection connection = dataSource.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_ID);
			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				book = new Book.Builder()
						.withId(resultSet.getLong(Book.ID_COLUMN))
						.withName(resultSet.getString(Book.NAME_COLUMN))
						.withAuthor(resultSet.getString(Book.AUTHOR_COLUMN))
						.withGenre(resultSet.getString(Book.GENRE_COLUMN))
						.build();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public void insert(Book book) {
		try(Connection connection = dataSource.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, book.getName());
			statement.setString(2, book.getAuthor());
			statement.setString(3, book.getGenre());
			statement.execute();

			ResultSet generatedKeys = statement.getGeneratedKeys();
			if (generatedKeys.next()) {
				book.setId(generatedKeys.getLong(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateName(Book book) {
		update(SQL_UPDATE_NAME, book.getName(), book.getId());
	}

	@Override
	public void updateAuthor(Book book) {
		update(SQL_UPDATE_AUTHOR, book.getAuthor(), book.getId());
	}

	@Override
	public void updateGenre(Book book) {
		update(SQL_UPDATE_GENRE, book.getGenre(), book.getId());
	}

	private void update(String sqlScript, String valueForUpdate, Long id) {
		try(Connection connection = dataSource.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sqlScript);
			statement.setString(1, valueForUpdate);
			statement.setLong(2, id);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Book book) {
		try(Connection connection = dataSource.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(SQL_DELETE);
			statement.setLong(1, book.getId());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}