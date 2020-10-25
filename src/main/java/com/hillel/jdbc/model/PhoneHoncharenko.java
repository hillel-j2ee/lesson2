package com.hillel.jdbc.model;

public class PhoneHoncharenko {
    public static final String TABLE_NAME = "phoneShop";
    public static final String ID_COLUMN = "id";
    public static final String MODEL_COLUMN = "model";
    public static final String PRICE_COLUMN = "price";

    private Long id;
    private String model;
    private Integer price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
