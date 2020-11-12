package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.model.Delete;
import hu.uni.eku.tzs.service.exceptions.DeleteAlreadyExistsException;

import java.util.Collection;

public interface DeleteService {

    void record(Delete delete) throws DeleteAlreadyExistsException;

    Collection<Delete> readAll();
}