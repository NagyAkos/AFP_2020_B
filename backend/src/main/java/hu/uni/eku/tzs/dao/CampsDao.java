package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Camps;

import java.util.Collection;

public interface CampsDao {

    void create(Camps camps);

    Collection<Camps> readAll();

    void update(Camps original, Camps updated);

    void delete(int id);
}
