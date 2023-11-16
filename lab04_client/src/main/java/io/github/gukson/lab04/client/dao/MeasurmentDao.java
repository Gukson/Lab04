package io.github.gukson.lab04.client.dao;

import io.github.gukson.lab04.client.model.Measurment;

import java.util.List;
import java.util.Optional;

public class MeasurmentDao implements Dao<Measurment> {

    @Override
    public Optional<Measurment> find(long id) {
        return Optional.empty();
    }

    @Override
    public List<Measurment> findAll() {
        return null;
    }

    @Override
    public Measurment save(Measurment measurment) {
        return null;
    }
}
