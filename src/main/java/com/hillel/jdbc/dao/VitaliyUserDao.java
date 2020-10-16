package com.hillel.jdbc.dao;

import com.hillel.jdbc.model.VitaliyUser;

import java.util.List;

public interface VitaliyUserDao {
    String SQL_FIND_ALL = "select * from " + VitaliyUser.TABLE_NAME;
    String SQL_FIND_BY_ID = SQL_FIND_ALL + " where " + VitaliyUser.ID_COLUMN + " = ?";
    String SQL_INSERT = "insert into " + VitaliyUser.TABLE_NAME + " (" + VitaliyUser.CREATED_COLUMN + ", " +
                                                                         VitaliyUser.STATUS_COLUMN + ", " +
                                                                         VitaliyUser.NAME_COLUMN + ", " +
                                                                         VitaliyUser.EMAIL_COLUMN + ", " +
                                                                         VitaliyUser.PASSWORD_COLUMN +
                        ") values (?, ?, ?, ?, ?)";
    String SQL_UPDATE = "update " + VitaliyUser.TABLE_NAME + " set " + VitaliyUser.CREATED_COLUMN + "= ?, " +
                                                                       VitaliyUser.STATUS_COLUMN + "= ?, " +
                                                                       VitaliyUser.NAME_COLUMN + "= ?, " +
                                                                       VitaliyUser.EMAIL_COLUMN + "= ?, " +
                                                                       VitaliyUser.PASSWORD_COLUMN + "= ?" +
                         " where " + VitaliyUser.ID_COLUMN + " = ?";
    String SQL_DELETE = "delete from " + VitaliyUser.TABLE_NAME + " where " + VitaliyUser.ID_COLUMN + " = ?";

    List<VitaliyUser> findAll();
    VitaliyUser findById(Long id);
    void insert(VitaliyUser vitaliyUser);
    void update(VitaliyUser vitaliyUser);
    void delete(VitaliyUser vitaliyUser);
}
