package com.hillel.jdbc.model;

import lombok.Data;

import java.util.Date;

@Data
public class VitaliyBaseEntity {
    public static final String ID_COLUMN = "id";
    public static final String CREATED_COLUMN = "created";
    public static final String STATUS_COLUMN = "status";

    private Long id;
    private Date created;
    private VitaliyStatus status;
}
