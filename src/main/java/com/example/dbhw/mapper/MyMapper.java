package com.example.dbhw.mapper;

import com.example.dbhw.model.MyEntity;

import java.util.List;

public interface MyMapper<T extends MyEntity> {
    void create(T t);

    void update(T t);

    void delete(int id);

    T getById(int id);

    List<T> getAll();

    List<T> getByName(String name);
}
