package com.hillel.jdbc.model;

import lombok.Data;

@Data
public class VitaliyUser extends VitaliyBaseEntity {
    public static final String TABLE_NAME = "vitaliy_user";
    public static final String NAME_COLUMN = "name";
    public static final String EMAIL_COLUMN = "email";
    public static final String PASSWORD_COLUMN = "password";

    private String name;
    private String email;
    private String password;

}
