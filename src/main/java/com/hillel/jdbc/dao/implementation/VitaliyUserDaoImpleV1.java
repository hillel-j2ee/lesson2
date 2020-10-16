package com.hillel.jdbc.dao.implementation;

import com.hillel.jdbc.dao.VitaliyUserDao;
import com.hillel.jdbc.dao.implementation.mycrud.CRUD;
import com.hillel.jdbc.dao.implementation.mycrud.MyRowMapper;
import com.hillel.jdbc.model.VitaliyStatus;
import com.hillel.jdbc.model.VitaliyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class VitaliyUserDaoImpleV1 implements VitaliyUserDao {
   @Autowired
   private CRUD<VitaliyUser> crud;

   public List<VitaliyUser> findAll() {
      return crud.findAll(SQL_FIND_ALL, new UserMapper());
   }

   public VitaliyUser findById(Long id) {
      return crud.findById(SQL_FIND_BY_ID, id, new UserMapper());
   }

   public void insert(VitaliyUser user) {
        Long id = crud.insert(SQL_INSERT, new UserMapper().rowMap(user));
        user.setId(id);
   }

   public void update(VitaliyUser user) {
       crud.update(SQL_UPDATE, user.getId(), new UserMapper().rowMap(user));
   }

   public void delete(VitaliyUser usere) {
       crud.delete(SQL_DELETE, usere.getId());
   }

   private static class UserMapper implements MyRowMapper<VitaliyUser> {

      @Override
      public VitaliyUser mapRow(ResultSet rs) throws SQLException {
          VitaliyUser user = new VitaliyUser();

          user.setId(rs.getLong("id"));
          user.setCreated(rs.getDate("created"));
          user.setStatus(Enum.valueOf(VitaliyStatus.class, rs.getString("status")));
          user.setName(rs.getString("name"));
          user.setEmail(rs.getString("email"));
          user.setPassword(rs.getString("password"));

          return user;
      }

      @Override
      public Map<Integer, Object> rowMap(VitaliyUser vitaliyUser) {
          Map<Integer, Object> result = new HashMap<Integer, Object>();

          result.put(1, vitaliyUser.getCreated());
          result.put(2, String.valueOf(vitaliyUser.getStatus()));
          result.put(3, vitaliyUser.getName());
          result.put(4, vitaliyUser.getEmail());
          result.put(5, vitaliyUser.getPassword());

          return result;
      }
   }
}

