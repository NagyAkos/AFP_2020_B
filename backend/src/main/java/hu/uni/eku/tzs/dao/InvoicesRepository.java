package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.dao.entity.Invoices;
import org.springframework.data.repository.CrudRepository;

public interface InvoicesRepository extends CrudRepository<Invoices, Integer> {
}
