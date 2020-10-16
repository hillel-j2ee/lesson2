package com.hillel.jdbc.dao.implementation.mycrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class VitaliyCRUD<T> implements CRUD<T> {
    @Autowired
    private DataSource dataSource;

    @Override
    public <T> List<T> findAll(String sql, MyRowMapper<T> myRowMapper) {

        List<T> result = new ArrayList<T>();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                result.add(myRowMapper.mapRow(rs));
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

    @Override
    public <T> T findById(String sql, Long id, MyRowMapper<T> myRowMapper) {

        T result = null;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                result = myRowMapper.mapRow(rs);
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

    @Override
    public Long insert(String sql, Map<Integer, Object> param) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            for (Integer key: param.keySet()){
                statement.setObject(key, param.get(key));
            }
            statement.execute();

            ResultSet generatedkeys = statement.getGeneratedKeys();
            if (generatedkeys.next()) {
               return generatedkeys.getLong(1);
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
        return null;
    }

    @Override
    public void update(String sql, Long id, Map<Integer, Object> param) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            for (Integer key: param.keySet()){
                statement.setObject(key, param.get(key));
            }
            statement.setObject(param.size()+1, id);
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

    @Override
    public void delete(String sql, Long id) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
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
