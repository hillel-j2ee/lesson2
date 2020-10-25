package com.hillel.jdbc.dao;

import java.util.List;
import java.util.Optional;

public interface HoncharenkoShopDao <T>{
    Optional<T> getById(long id);

    List<T> getAll();

    void save(T t);

    void update(T t);

    void delete(T t);

}
