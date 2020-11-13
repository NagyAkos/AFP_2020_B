package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.dao.CampsDao;
import hu.uni.eku.tzs.model.Camps;
import hu.uni.eku.tzs.service.exceptions.CampsAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@Service
public class CampsServiceImpl implements CampsService{

    private final CampsDao dao;

    @Override
    public void record(Camps camps) throws CampsAlreadyExistsException {
        final boolean isAlreadyRecorded = dao.readAll()
                .stream()
                .anyMatch( c ->
                        c.getId() == camps.getId());
        if(isAlreadyRecorded){
            log.info("Camp {} is already recorded!", camps);
            throw new CampsAlreadyExistsException(String.format("Camp (%s) already exists!", camps.toString()));

        }
        dao.create(camps);
    }

    @Override
    public Collection<Camps> readAll() {
        return dao.readAll();
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }


}
