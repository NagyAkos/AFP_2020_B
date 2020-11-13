package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.model.Camps;
import hu.uni.eku.tzs.service.exceptions.CampsAlreadyExistsException;

import java.util.Collection;

public interface CampsService {

    void record(Camps camps) throws CampsAlreadyExistsException;

    Collection<Camps> readAll();
}

