package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Guests;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class GuestsDaoImpl implements GuestsDao {

    private final GuestsRepository repository;

    @Override
    public void create(Guests guests) {
        repository.save(GuestsEntityModelConverter.model2entity(guests));
    }

    @Override
    public Collection<Guests> readAll() {
        return StreamSupport.stream(repository.findAll().spliterator(),false)
                .map(entity -> GuestsEntityModelConverter.entity2model(entity))
                .collect(Collectors.toList());
    }

    @Override
    public void update(Guests original, Guests updated) {

    }

    @Override
    public void delete(Guests guests) {

    }

    private static class GuestsEntityModelConverter {

        private static Guests entity2model(hu.uni.eku.tzs.dao.entity.Guests entity){
            return new Guests(
                    entity.getId(),
                    entity.getGuestName(),
                    entity.getPaymentMethod(),
                    entity.getCampingId(),
                    entity.getReserveDate()
            );
        }

        private static hu.uni.eku.tzs.dao.entity.Guests model2entity(Guests model){
            return hu.uni.eku.tzs.dao.entity.Guests.builder()
                    .id(model.getId())
                    .guestName(model.getGuestName())
                    .paymentMethod(model.getPaymentMethod())
                    .campingId(model.getCampingId())
                    .reserveDate(model.getReserveDate())
                    .build();
        }

    }
}
