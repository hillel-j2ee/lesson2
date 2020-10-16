package com.hillel.jdbc.dao.implementation.mycrud;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public interface MyRowMapper<T> {
    T mapRow(ResultSet rs) throws SQLException;
    Map<Integer, Object> rowMap (T t) throws SQLException;
}
