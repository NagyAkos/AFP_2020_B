package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Reserves;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class ReservesDaoImpl implements ReservesDao{
    private final ReservesRepository repository;

    @Override
    public void create(Reserves reserves) {
        repository.save(ReservesDaoImpl.ReservesEntityModelConverter.model2entity(reserves));
    }

    @Override
    public Collection<Reserves> readAll() {
        return StreamSupport.stream(repository.findAll().spliterator(),false)
                .map(entity -> ReservesDaoImpl.ReservesEntityModelConverter.entity2model(entity))
                .collect(Collectors.toList());
    }

    @Override
    public void update(Reserves original, Reserves updated) {

    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    private static class ReservesEntityModelConverter {

        private static Reserves entity2model(hu.uni.eku.tzs.dao.entity.Reserves entity){
            return new Reserves(
                    entity.getId(),
                    entity.getGuestId(),
                    entity.getCampId(),
                    entity.isCampingStyle(),
                    entity.isElectricity(),
                    entity.getPrice(),
                    entity.getReserveStart(),
                    entity.getReserveEnd()
            );
        }

        private static hu.uni.eku.tzs.dao.entity.Reserves model2entity(Reserves model){
            return hu.uni.eku.tzs.dao.entity.Reserves.builder()
                    .id(model.getId())
                    .guestId(model.getGuestId())
                    .campId(model.getCampId())
                    .campingStyle(model.isCampingStyle())
                    .electricity(model.isElectricity())
                    .price(model.getPrice())
                    .reserveStart(model.getReserveStart())
                    .reserveEnd(model.getReserveEnd())
                    .build();
        }

    }
}
