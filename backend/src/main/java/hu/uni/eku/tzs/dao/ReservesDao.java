package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Reserves;
import java.util.Collection;

public interface ReservesDao {
    void create(Reserves reserves);

    Collection<Reserves> readAll();

    void update(Reserves original, Reserves updated);

    void delete(int id);
}
