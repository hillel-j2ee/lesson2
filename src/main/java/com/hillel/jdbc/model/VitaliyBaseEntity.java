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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public VitaliyStatus getStatus() {
        return status;
    }

    public void setStatus(VitaliyStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "VitaliyBaseEntity{" +
                "id=" + id +
                ", created=" + created +
                ", status=" + status +
                '}';
    }
}
