package com.hillel.jdbc.dao.implementation.mycrud;

import java.util.List;
import java.util.Map;

public interface CRUD<T> {
    <T> List<T> findAll(String sql, MyRowMapper<T> myRowMapper);
    <T> T findById(String sql, Long id, MyRowMapper<T> myRowMapper);
    Long insert(String sql, Map<Integer, Object> param);
    void update(String sql, Long id, Map<Integer, Object> param);
    void delete(String sql, Long id);
}
