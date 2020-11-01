package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Guests;

import java.util.Collection;

public interface GuestsDao {

    void create(Guests guests);

    Collection<Guests> readAll();

    void update(Guests original, Guests updated);

    void delete(Guests guests);
}
