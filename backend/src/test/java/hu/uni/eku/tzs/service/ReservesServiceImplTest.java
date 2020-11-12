package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.dao.ReservesDao;
import hu.uni.eku.tzs.model.Reserves;
import hu.uni.eku.tzs.service.exceptions.ReservesAlreadyExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ReservesServiceImplTest {

    private final ReservesDao dao = mock(ReservesDao.class);
    private ReservesService service;


    @BeforeEach
    void setUp() {
        Mockito.reset(dao);
        service = new ReservesServiceImpl(dao);
    }

    @Test
    void record() throws ReservesAlreadyExistsException {
        Reserves reserves = new Reserves(1,1,true,true);
        service.record(reserves);
        verify(dao).create(any());
    }

    @Test
    void recordExistingGuests() {
        Reserves reserves = new Reserves(2,2,true,false);
        when(dao.readAll()).thenReturn(List.of(reserves));
        assertThrows(ReservesAlreadyExistsException.class, () -> service.record(reserves));
        verify(dao, never()).create(any());
    }

    @Test
    void readAll() {
        Collection<Reserves> daoResponse = List.of(
                new Reserves(3,3,true,true),
                new Reserves(4,4,true,true)
        );
        when(dao.readAll()).thenReturn(daoResponse);

        Collection<Reserves> actual = service.readAll();

        assertEquals(daoResponse,actual);
    }

}
