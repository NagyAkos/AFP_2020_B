package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Invoices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class InvoicesDaoImpl implements InvoicesDao{

    private final InvoicesRepository repository;

    @Override
    public void create(Invoices invoices) {
        repository.save(InvoicesDaoImpl.InvoicesEntityModelConverter.model2entity(invoices));
    }

    @Override
    public Collection<Invoices> readAll() {
        return StreamSupport.stream(repository.findAll().spliterator(),false)
                .map(entity -> InvoicesDaoImpl.InvoicesEntityModelConverter.entity2model(entity))
                .collect(Collectors.toList());
    }

    @Override
    public void update(Invoices original, Invoices updated) {

    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    private static class InvoicesEntityModelConverter {

        private static Invoices entity2model(hu.uni.eku.tzs.dao.entity.Invoices entity){
            return new Invoices(
                    entity.getId(),
                    entity.getQuestId(),
                    entity.getPaymentMehtod(),
                    entity.getReserveId()
            );
        }

        private static hu.uni.eku.tzs.dao.entity.Invoices model2entity(Invoices model){
            return hu.uni.eku.tzs.dao.entity.Invoices.builder()
                    .id(model.getId())
                    .questId(model.getQuestId())
                    .reserveId(model.getReserveId())
                    .paymentMehtod(model.getPaymentMethod())
                    .build();
        }

    }
}
