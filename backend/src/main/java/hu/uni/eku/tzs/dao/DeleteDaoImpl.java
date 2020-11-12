package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Delete;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service

public class DeleteDaoImpl implements DeleteDao{

    private final DeleteRepository repository;

    @Override
    public void create(Delete delete) {
        repository.save(DeleteDaoImpl.DeleteEntityModelConverter.model2entity(delete));
    }

    @Override
    public Collection<Delete> readAll() {
        return StreamSupport.stream(repository.findAll().spliterator(),false)
                .map(entity -> DeleteDaoImpl.DeleteEntityModelConverter.entity2model(entity))
                .collect(Collectors.toList());
    }

    @Override
    public void update(Delete original, Delete updated) {

    }

    @Override
    public void delete(Delete delete) {

    }

    private static class DeleteEntityModelConverter {

        private static Delete entity2model(hu.uni.eku.tzs.dao.entity.Delete entity){
            return new Delete(
                    entity.getId()
            );
        }

        private static hu.uni.eku.tzs.dao.entity.Delete model2entity(Delete model){
            return hu.uni.eku.tzs.dao.entity.Delete.builder()
                    .id(model.getId())
                    .build();
        }

    }

}
