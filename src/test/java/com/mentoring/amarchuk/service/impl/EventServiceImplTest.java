package by.prohor.service.impl;

import by.prohor.dao.EventDao;
import by.prohor.model.Event;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EventServiceImplTest {

    @InjectMocks
    EventServiceImpl eventService;

    @Mock
    EventDao eventDao;

    @Test
    void getEventById() {
        Event event = new Event((long) 1, "Mock", new Date("12/12/2012"));

        when(eventDao.getEventById(any(Long.class))).thenReturn(event);

        Event eventById = eventService.getEventById(0);
        assertEquals(eventById, event);
    }

    @Test
    void getEventsByTitle() {
        Event event1 = new Event((long) 1, "Mock", new Date("12/12/2012"));
        Event event2 = new Event((long) 1, "Mock", new Date("12/12/2012"));
        List<Event> list = Arrays.asList(event1, event2);

        when(eventDao.getEventsByTitle(any(), any(Integer.class), any(Integer.class))).thenReturn(list);

        List<Event> mock = eventService.getEventsByTitle("Mock", 1, 1);
        assertEquals(list.size(), mock.size());
    }

    @Test
    void getEventsForDay() {
        Event event1 = new Event((long) 1, "Mock", new Date("12/12/2012"));
        Event event2 = new Event((long) 1, "Mock", new Date("12/12/2012"));
        List<Event> list = Arrays.asList(event1, event2);

        when(eventDao.getEventsForDay(any(), any(Integer.class), any(Integer.class))).thenReturn(list);

        List<Event> mock = eventService.getEventsForDay(new Date("12/12/2012"), 1, 1);
        assertEquals(list.size(), mock.size());
    }

    @Test
    void createEvent() {
        Event event = new Event((long) 1, "Mock", new Date("12/12/2012"));
        when(eventDao.createEvent(any())).thenReturn(event);
        assertEquals(eventService.createEvent(event), event);

    }

    @Test
    void updateEvent() {
        Event event = new Event((long) 1, "Mock", new Date("12/12/2012"));
        when(eventDao.updateEvent(any())).thenReturn(event);
        assertEquals(eventService.updateEvent(event), event);
    }

    @Test
    void deleteEvent() {
        when(eventDao.deleteEvent(any(Long.class))).thenReturn(true);
        assertTrue(eventService.deleteEvent(1));
    }
}