package com.hillel.jdbc.dao.implementation;

import com.hillel.jdbc.dao.KryvorotenkosShopDao;
import com.hillel.jdbc.model.KryvorotenkosShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class KryvorotenkosShopDaoImplementation implements KryvorotenkosShopDao {
    @Autowired
    private DataSource dataSource;

    public List<KryvorotenkosShop> findAll() {
        List<KryvorotenkosShop> result = new ArrayList<KryvorotenkosShop>();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                KryvorotenkosShop kryvorotenkosShop = new KryvorotenkosShop();
                kryvorotenkosShop.setId(rs.getLong(KryvorotenkosShop.ID_COLUMN));
                kryvorotenkosShop.setAddress(rs.getString(KryvorotenkosShop.ADDRESS_COLUMN));
                result.add(kryvorotenkosShop);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                dataSource.getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public KryvorotenkosShop findById(Long id) {
        KryvorotenkosShop kryvorotenkosShop = null;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_ID);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                kryvorotenkosShop = new KryvorotenkosShop();
                kryvorotenkosShop.setId(rs.getLong(KryvorotenkosShop.ID_COLUMN));
                kryvorotenkosShop.setAddress(rs.getString(KryvorotenkosShop.ADDRESS_COLUMN));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                dataSource.getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return kryvorotenkosShop;
    }

    public void insert(KryvorotenkosShop kryvorotenkosShop) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, kryvorotenkosShop.getAddress());
            statement.execute();

            ResultSet generatedkeys = statement.getGeneratedKeys();
            if (generatedkeys.next()) {
                kryvorotenkosShop.setId(generatedkeys.getLong(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                dataSource.getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(KryvorotenkosShop kryvorotenkosShop) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE);
            statement.setString(1, kryvorotenkosShop.getAddress());
            statement.setLong(2, kryvorotenkosShop.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                dataSource.getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(KryvorotenkosShop kryvorotenkosShop) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE);
            statement.setLong(1, kryvorotenkosShop.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                dataSource.getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}