package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.dao.entity.Guests;
import org.springframework.data.repository.CrudRepository;

public interface GuestsRepository extends CrudRepository<Guests, Integer> {
}
