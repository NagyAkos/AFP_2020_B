package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.model.Guests;
import hu.uni.eku.tzs.service.exceptions.GuestsAlreadyExistsException;

import java.util.Collection;

public interface GuestsService {

    void record(Guests guests) throws GuestsAlreadyExistsException;

    Collection<Guests> readAll();
}
