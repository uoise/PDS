package com.example.dbhw.service;

import com.example.dbhw.model.MyEntity;
import com.example.dbhw.model.User;

import java.util.List;

public interface MyService<D, V extends MyEntity> {
    void create(User user, D DTO);

    void update(User user, int id, D DTO);

    void delete(int id);

    List<V> getAll();

    V getById(int id);
}
