package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.dao.InvoicesDao;
import hu.uni.eku.tzs.model.Invoices;
import hu.uni.eku.tzs.service.exceptions.InvoicesAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@Service

public class InvoicesServiceImpl implements InvoicesService{

    private final InvoicesDao dao;

    @Override
    public void record(Invoices invoices) throws InvoicesAlreadyExistsException {
        final boolean isAlreadyRecorded = dao.readAll()
                .stream()
                .anyMatch( i ->
                        i.getId() == invoices.getId()

                &&i.getQuestId() == invoices.getQuestId()
                && i.getReserveId()==invoices.getReserveId()
                &&
                i.getPaymentMethod() == invoices.getPaymentMethod());
        if(isAlreadyRecorded){
            log.info("Invoice {} is already recorded!", invoices);
            throw new InvoicesAlreadyExistsException(String.format("Invoice (%s) already exists!", invoices.toString()));

        }
        dao.create(invoices);
    }

    @Override
    public Collection<Invoices> readAll() {
        return dao.readAll();
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

}
