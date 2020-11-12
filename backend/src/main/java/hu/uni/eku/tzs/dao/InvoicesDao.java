package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Invoices;

import java.util.Collection;

public interface InvoicesDao {

    void create(Invoices invoices);

    Collection<Invoices> readAll();

    void update(Invoices original, Invoices updated);

    void delete(Invoices invoices);
}
