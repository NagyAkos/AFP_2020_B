package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.model.Reserves;
import hu.uni.eku.tzs.service.exceptions.ReservesAlreadyExistsException;

import java.util.Collection;

public interface ReservesService {

    void record(Reserves reserves) throws ReservesAlreadyExistsException;

    Collection<Reserves> readAll();

}
