package com.mentoring.amarchuk.dao;

import com.mentoring.amarchuk.dao.EventDao;
import com.mentoring.amarchuk.dao.EventDaoList;
import com.mentoring.amarchuk.model.Event;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringJUnitConfig(EventDaoTest.Config.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class EventDaoTest {


    @Configuration
    static class Config {

        @Bean
        EventDao createEvent() {
            return new EventDaoList();
        }

        @Bean
        List<Event> created() {
            return new ArrayList<>();
        }

    }

    @Autowired
    private EventDao eventDao;

    Event event = new Event((long) 1, "Test", new Date("10/07/2021"));
    Event event2 = new Event((long) 2, "Test", new Date("10/07/2021"));


    @Test
    void getEventById() {
        eventDao.createEvent(event);
        assertEquals(event, eventDao.getEventById(event.getId()));
    }

    @Test
    void getEventsByTitle() {

        eventDao.createEvent(event);
        eventDao.createEvent(event2);
        assertEquals(2, eventDao.getEventsByTitle("Test", 1, 1).size());
    }

    @Test
    void getEventsByTitleReturnEmptyList() {
        assertTrue(eventDao.getEventsByTitle("Test", 1, 1).isEmpty());
    }

    @Test
    void getEventsForDay() {
        eventDao.createEvent(event);
        Date date = new Date("10/07/2021");
        assertEquals(1, eventDao.getEventsForDay(date, 1, 1).size());
    }

    @Test
    void createEvent() {
        assertEquals(0, eventDao.size());
        eventDao.createEvent(event);
        assertEquals(1, eventDao.size());
    }

    @Test
    void deleteEvent() {
        eventDao.createEvent(event);
        assertEquals(event, eventDao.getEventById(event.getId()));
        assertTrue(eventDao.deleteEvent(event.getId()));
    }


}