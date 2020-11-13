package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.dao.GuestsDao;
import hu.uni.eku.tzs.model.Guests;
import hu.uni.eku.tzs.service.exceptions.GuestsAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@Service
public class GuestsServiceImpl implements GuestsService {

    private final GuestsDao dao;

    @Override
    public void record(Guests guests) throws GuestsAlreadyExistsException {
        final boolean isAlreadyRecorded = dao.readAll()
                .stream()
                .anyMatch( g ->
                                g.getId() == guests.getId()
                                &&
                                g.getGuestName() == guests.getGuestName()
                                &&
                                        g.getEmail() == guests.getEmail()
                                &&
                                        g.getPhone() == guests.getPhone());
        if(isAlreadyRecorded){
            log.info("Complex Number {} is already recorded!", guests);
            throw new GuestsAlreadyExistsException(String.format("Complex Number (%s) already exists!", guests.toString()));

        }
        dao.create(guests);
    }

    @Override
    public Collection<Guests> readAll() {
        return dao.readAll();
    }
}
