package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.dao.GuestsDao;
import hu.uni.eku.tzs.model.Guests;
import hu.uni.eku.tzs.service.exceptions.GuestsAlreadyExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class GuestsServiceImplTest {

    private final GuestsDao dao = mock(GuestsDao.class);
    private GuestsService service;


    @BeforeEach
    void setUp() {
        Mockito.reset(dao);
        service = new GuestsServiceImpl(dao);
    }

    @Test
    void record() throws GuestsAlreadyExistsException {
        Guests guests = new Guests(1,"Jóska","asd@as.com",06201231231);
        service.record(guests);
        verify(dao).create(any());
    }

    @Test
    void recordExistingGuests() {
        Guests guests = new Guests(1,"Jóska","asd@as.com",06201231231);
        when(dao.readAll()).thenReturn(List.of(guests));
        assertThrows(GuestsAlreadyExistsException.class, () -> service.record(guests));
        verify(dao, never()).create(any());
    }

    @Test
    void readAll() {
        Collection<Guests> daoResponse = List.of(
                new Guests(1,"Jóska","asd@as.com",06201231231),
                new Guests(2,"Jóska","asd@as.com",06201231231)

        );
        when(dao.readAll()).thenReturn(daoResponse);

        Collection<Guests> actual = service.readAll();

        assertEquals(daoResponse,actual);
    }
}