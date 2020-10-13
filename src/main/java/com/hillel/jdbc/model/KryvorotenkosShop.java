package com.hillel.jdbc.model;

public class KryvorotenkosShop {
    public static final String TABLE_NAME = "kryvorotenkos_shop";
    public static final String ID_COLUMN = "id";
    public static final String ADDRESS_COLUMN = "address";

    private Long id;
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "KryvorotenkosShop{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}
