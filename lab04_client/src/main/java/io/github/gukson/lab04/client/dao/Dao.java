package io.github.gukson.lab04.client.dao;

import java.util.List;
import java.util.Optional;

public interface Dao <T>{
    Optional<T> find(Integer id, String tableName);
    List<T> findAll(String tableName);
    T save(T t, String tableName);
}