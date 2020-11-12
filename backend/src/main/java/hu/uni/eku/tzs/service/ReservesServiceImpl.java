package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.dao.ReservesDao;
import hu.uni.eku.tzs.model.Reserves;
import hu.uni.eku.tzs.service.exceptions.ReservesAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@Service
public class ReservesServiceImpl implements ReservesService{
    private final ReservesDao dao;

    @Override
    public void record(Reserves reserves) throws ReservesAlreadyExistsException {
        final boolean isAlreadyRecorded = dao.readAll()
                .stream()
                .anyMatch( r ->
                                r.getId() == reserves.getId()
                                &&
                                r.getGuestName() == reserves.getGuestName()
                                &&
                                r.isCampingStyle() == reserves.isCampingStyle()
                                &&
                                r.isElectricity() == reserves.isElectricity());
        if(isAlreadyRecorded){
            log.info("Reserve {} is already recorded!", reserves);
            throw new ReservesAlreadyExistsException(String.format("Reserve (%s) already exists!", reserves.toString()));

        }
        dao.create(reserves);
    }

    @Override
    public Collection<Reserves> readAll() {
        return dao.readAll();
    }




}
