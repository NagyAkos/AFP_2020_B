package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.dao.InvoicesDao;
import hu.uni.eku.tzs.model.Invoices;
import hu.uni.eku.tzs.service.exceptions.InvoicesAlreadyExistsException;
import io.swagger.models.auth.In;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class InvoicesServiceImplTest {

    private final InvoicesDao dao = mock(InvoicesDao.class);
    private InvoicesService service;


    @BeforeEach
    void setUp() {
        Mockito.reset(dao);
        service = new InvoicesServiceImpl(dao);
    }

    @Test
    void record() throws InvoicesAlreadyExistsException {
        Invoices invoices = new Invoices(1,20000);
        service.record(invoices);
        verify(dao).create(any());
    }

    @Test
    void recordExistingInvoices() {
        Invoices invoices = new Invoices(2,100000);
        when(dao.readAll()).thenReturn(List.of(invoices));
        assertThrows(InvoicesAlreadyExistsException.class, () -> service.record(invoices));
        verify(dao, never()).create(any());
    }

    @Test
    void readAll() {
        Collection<Invoices> daoResponse = List.of(
                new Invoices(3,35000),
                new Invoices(4,55555)

        );
        when(dao.readAll()).thenReturn(daoResponse);

        Collection<Invoices> actual = service.readAll();

        assertEquals(daoResponse,actual);
    }


}
