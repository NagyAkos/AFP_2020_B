package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.dao.CampsDao;
import hu.uni.eku.tzs.model.Camps;
import hu.uni.eku.tzs.service.exceptions.CampsAlreadyExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


public class CampsServiceImplTest {

    private final CampsDao dao = mock(CampsDao.class);
    private CampsService service;


    @BeforeEach
    void setUp() {
        Mockito.reset(dao);
        service = new CampsServiceImpl(dao);
    }

    @Test
    void record() throws CampsAlreadyExistsException {
        Camps camps = new Camps(1);
        service.record(camps);
        verify(dao).create(any());
    }

    @Test
    void recordExistingGuests() {
        Camps camps = new Camps(2);
        when(dao.readAll()).thenReturn(List.of(camps));
        assertThrows(CampsAlreadyExistsException.class, () -> service.record(camps));
        verify(dao, never()).create(any());
    }

    @Test
    void readAll() {
        Collection<Camps> daoResponse = List.of(
                new Camps(3),
                new Camps(4)

        );
        when(dao.readAll()).thenReturn(daoResponse);

        Collection<Camps> actual = service.readAll();

        assertEquals(daoResponse,actual);
    }


}
