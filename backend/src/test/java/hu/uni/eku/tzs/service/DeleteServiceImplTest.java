package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.dao.DeleteDao;
import hu.uni.eku.tzs.model.Delete;
import hu.uni.eku.tzs.service.exceptions.DeleteAlreadyExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class DeleteServiceImplTest {

    private final DeleteDao dao = mock(DeleteDao.class);
    private DeleteService service;


    @BeforeEach
    void setUp() {
        Mockito.reset(dao);
        service = new DeleteServiceImpl(dao);
    }

    @Test
    void record() throws DeleteAlreadyExistsException {
        Delete delete = new Delete(1);
        service.record(delete);
        verify(dao).create(any());
    }

    @Test
    void recordExistingDelete() {
        Delete delete = new Delete(2);
        when(dao.readAll()).thenReturn(List.of(delete));
        assertThrows(DeleteAlreadyExistsException.class, () -> service.record(delete));
        verify(dao, never()).create(any());
    }

    @Test
    void readAll() {
        Collection<Delete> daoResponse = List.of(
                new Delete(3),
                new Delete(4)

        );
        when(dao.readAll()).thenReturn(daoResponse);

        Collection<Delete> actual = service.readAll();

        assertEquals(daoResponse,actual);
    }
}
