//package com.mentoring.amarchuk.dao;
//
//import com.mentoring.amarchuk.dao.EventDao;
//import com.mentoring.amarchuk.dao.EventDaoList;
//import com.mentoring.amarchuk.model.Event;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//@SpringJUnitConfig(EventDaoTest.Config.class)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
//class EventDaoTest {
//
//
//    @Autowired
//    private EventDao eventDao;
//
//
//    @Test
//    void getEventById() {
//        Event event = new Event((long) 1, "Test", new Date("12/12/2012"));
//        eventDao.createEvent(event);
//        assertEquals(event, eventDao.getEventById(event.getId()));
//    }
//
//    @Test
//    void getEventsByTitle() {
//        Event event1 = new Event((long) 1, "Test", new Date("12/12/2012"));
//        Event event2 = new Event((long) 2, "Test", new Date("12/12/2012"));
//        eventDao.createEvent(event1);
//        eventDao.createEvent(event2);
//        assertEquals(2, eventDao.getEventsByTitle("Test", 1, 1).size());
//    }
//
//    @Test
//    void getEventsByTitleReturnEmptyList() {
//        assertTrue(eventDao.getEventsByTitle("Test", 1, 1).isEmpty());
//    }
//
//    @Test
//    void getEventsForDay() {
//        Event event = new Event((long) 1, "Test", new Date("12/12/2012"));
//        eventDao.createEvent(event);
//        Date date = new Date("12/12/2012");
//        assertEquals(1, eventDao.getEventsForDay(date, 1, 1).size());
//    }
//
//    @Test
//    void createEvent() {
//        Event event = new Event((long) 1, "Test", new Date("12/12/2012"));
//        assertEquals(0, eventDao.size());
//        eventDao.createEvent(event);
//        assertEquals(1, eventDao.size());
//    }
//
//    @Test
//    void updateEvent() {
//        Event event = new Event((long) 1, "Test", new Date("12/12/2012"));
//    }
//
//    @Test
//    void deleteEvent() {
//        Event event = new Event((long) 1, "Test", new Date("12/12/2012"));
//        eventDao.createEvent(event);
//        assertEquals(event, eventDao.getEventById(event.getId()));
//        assertTrue(eventDao.deleteEvent(event.getId()));
//    }
//
//    @Configuration
//    static class Config {
//
//        @Bean
//        EventDao createEvent() {
//            return new EventDaoList();
//        }
//
//        @Bean
//        List<Event> created() {
//            return new ArrayList<>();
//        }
//
//    }
//}