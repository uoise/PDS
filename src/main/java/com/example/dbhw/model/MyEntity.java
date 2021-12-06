package com.example.dbhw.model;

public interface MyEntity<T> {
    void DTOtoEntity(T DTO);
    String toString();
}
