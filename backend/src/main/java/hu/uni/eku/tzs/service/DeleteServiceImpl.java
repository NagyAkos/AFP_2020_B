package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.dao.DeleteDao;
import hu.uni.eku.tzs.model.Delete;
import hu.uni.eku.tzs.service.exceptions.DeleteAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@Service
public class DeleteServiceImpl implements DeleteService{

    private final DeleteDao dao;

    @Override
    public void record(Delete delete) throws DeleteAlreadyExistsException {
        final boolean isAlreadyRecorded = dao.readAll()
                .stream()
                .anyMatch( d ->
                        d.getId() == delete.getId());
        if(isAlreadyRecorded){
            log.info("Complex Number {} is already recorded!", delete);
            throw new DeleteAlreadyExistsException(String.format("Reserve to delete (%s) already exists!", delete.toString()));

        }
        dao.create(delete);
    }

    @Override
    public Collection<Delete> readAll() {
        return dao.readAll();
    }


}
