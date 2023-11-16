package io.github.gukson.lab04.client.dao;

import java.util.List;
import java.util.Optional;

public interface Dao <T>{
    Optional<T> find(long id);
    List<T> findAll();
    T save(T t);
}