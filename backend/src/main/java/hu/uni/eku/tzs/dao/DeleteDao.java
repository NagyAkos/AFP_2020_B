package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Delete;

import java.util.Collection;

public interface DeleteDao {

    void create(Delete delete);

    Collection<Delete> readAll();

    void update(Delete original, Delete updated);

    void delete(Delete guests);
}

