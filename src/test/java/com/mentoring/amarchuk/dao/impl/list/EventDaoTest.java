package by.prohor.dao.impl.list;

import by.prohor.dao.EventDao;
import by.prohor.model.Event;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:config.xml"})
class EventDaoTest {

    @Autowired
    private EventDao eventDao;

    @Test
    void getEventById() {
        Event event = new Event((long) 1, "Test", new Date("12/12/2012"));
        eventDao.createEvent(event);
        assertEquals(event, eventDao.getEventById(event.getId()));
    }

    @Test
    void getEventsByTitle() {
        Event event1 = new Event((long) 1, "Test", new Date("12/12/2012"));
        Event event2 = new Event((long) 2, "Test", new Date("12/12/2012"));
        eventDao.createEvent(event1);
        eventDao.createEvent(event2);
        assertEquals(2, eventDao.getEventsByTitle("Test", 1, 1).size());
    }

    @Test
    void getEventsByTitleReturnEmptyList() {
        assertTrue(eventDao.getEventsByTitle("Test", 1, 1).isEmpty());
    }

    @Test
    void getEventsForDay() {
        Event event = new Event((long) 1, "Test", new Date("12/12/2012"));
        eventDao.createEvent(event);
        Date date = new Date("12/12/2012");
        assertEquals(1, eventDao.getEventsForDay(date, 1, 1).size());
    }

    @Test
    void createEvent() {
        Event event = new Event((long) 1, "Test", new Date("12/12/2012"));
        assertEquals(0, eventDao.size());
        eventDao.createEvent(event);
        assertEquals(1, eventDao.size());
    }

    @Test
    void updateEvent() {
        Event event = new Event((long) 1, "Test", new Date("12/12/2012"));
    }

    @Test
    void deleteEvent() {
        Event event = new Event((long) 1, "Test", new Date("12/12/2012"));
        eventDao.createEvent(event);
        assertEquals(event, eventDao.getEventById(event.getId()));
        assertTrue(eventDao.deleteEvent(event.getId()));
    }
}