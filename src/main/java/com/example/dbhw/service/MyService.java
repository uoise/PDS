package com.example.dbhw.service;

import com.example.dbhw.model.MyEntity;

import java.util.List;

public interface MyService<D, V extends MyEntity>{
    void create(D DTO);
    void update(int id,D DTO);
    void delete(int id);
    List<V> getAll();
    V getById(int id);
}
