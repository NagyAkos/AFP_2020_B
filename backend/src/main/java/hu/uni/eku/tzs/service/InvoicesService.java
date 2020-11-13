package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.model.Invoices;
import hu.uni.eku.tzs.service.exceptions.InvoicesAlreadyExistsException;

import java.util.Collection;

public interface InvoicesService {

    void record(Invoices invoices) throws InvoicesAlreadyExistsException;

    Collection<Invoices> readAll();

    void delete(int id);
}

