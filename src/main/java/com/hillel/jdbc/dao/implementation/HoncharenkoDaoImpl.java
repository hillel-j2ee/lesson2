package com.hillel.jdbc.dao.implementation;

import com.hillel.jdbc.DataSource;
import com.hillel.jdbc.dao.HoncharenkoShopDao;
import com.hillel.jdbc.model.Item;
import com.hillel.jdbc.model.PhoneHoncharenko;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HoncharenkoDaoImpl implements HoncharenkoShopDao<PhoneHoncharenko> {
    String SQL_DELETE = "DELETE FROM" + PhoneHoncharenko.TABLE_NAME + "WHERE" + PhoneHoncharenko.ID_COLUMN + " = ?";
    String SQL_UPDATE = "UPDATE " + PhoneHoncharenko.TABLE_NAME + "set " + PhoneHoncharenko.MODEL_COLUMN + "= ?" + "set" + PhoneHoncharenko.PRICE_COLUMN + "= ? where " + Item.ID_COLUMN + " = ?";
    String SQL_FIND_ALL = "SELECT * FROM " + PhoneHoncharenko.TABLE_NAME;
    String SQL_FIND_BY_ID = SQL_FIND_ALL + " where " + PhoneHoncharenko.ID_COLUMN + " = ?";
    String SQL_INSERT = "insert into " + PhoneHoncharenko.TABLE_NAME + " (" + PhoneHoncharenko.MODEL_COLUMN + ", " + PhoneHoncharenko.PRICE_COLUMN + ") values (?, ?)";

    @Autowired
    DataSource dataSource;

    @Override
    public Optional<PhoneHoncharenko> getById(long id) {

        PhoneHoncharenko phoneHoncharenko = null;
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_ID);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                try (ResultSet cursor = statement.executeQuery()) {
                    if (!cursor.next()) {
                        return Optional.empty();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Optional.of(phoneHoncharenko);
    }

    @Override
    public List<PhoneHoncharenko> getAll() {
        List<PhoneHoncharenko> result = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                PhoneHoncharenko phoneHoncharenko = new PhoneHoncharenko();
                phoneHoncharenko.setId(rs.getLong(PhoneHoncharenko.ID_COLUMN));
                phoneHoncharenko.setModel(rs.getString(PhoneHoncharenko.MODEL_COLUMN));
                phoneHoncharenko.setPrice(rs.getInt(PhoneHoncharenko.PRICE_COLUMN));
                result.add(phoneHoncharenko);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void save(PhoneHoncharenko phoneHoncharenko) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, phoneHoncharenko.getModel());
            statement.setInt(2, phoneHoncharenko.getPrice());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(PhoneHoncharenko phoneHoncharenko) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE);
            statement.setString(1, phoneHoncharenko.getModel());
            statement.setInt(2, phoneHoncharenko.getPrice());
            statement.setLong(3, phoneHoncharenko.getId());
            statement.execute();
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    @Override
    public void delete(PhoneHoncharenko phoneHoncharenko) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE);
            statement.setLong(1, phoneHoncharenko.getId());
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
