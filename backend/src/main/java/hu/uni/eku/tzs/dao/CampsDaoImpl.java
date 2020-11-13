package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Camps;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class CampsDaoImpl implements CampsDao{

    private final CampsRepository repository;

    @Override
    public void create(Camps camps) {
        repository.save(CampsDaoImpl.CampsEntityModelConverter.model2entity(camps));
    }

    @Override
    public Collection<Camps> readAll() {
        return StreamSupport.stream(repository.findAll().spliterator(),false)
                .map(entity -> CampsDaoImpl.CampsEntityModelConverter.entity2model(entity))
                .collect(Collectors.toList());
    }

    @Override
    public void update(Camps original, Camps updated) {

    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    private static class CampsEntityModelConverter {

        private static Camps entity2model(hu.uni.eku.tzs.dao.entity.Camps entity){
            return new Camps(
                    entity.getId()
            );
        }

        private static hu.uni.eku.tzs.dao.entity.Camps model2entity(Camps model){
            return hu.uni.eku.tzs.dao.entity.Camps.builder()
                    .id(model.getId())
                    .build();
        }

    }
}
