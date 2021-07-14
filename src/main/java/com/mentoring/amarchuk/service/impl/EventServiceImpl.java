package by.prohor.service.impl;


import by.prohor.dao.EventDao;
import by.prohor.model.Event;
import by.prohor.service.EventService;

import java.util.Date;
import java.util.List;

/**
 * Created by Artsiom Prokharau 02.07.2021
 */


public class EventServiceImpl implements EventService {

    EventDao eventDao;

    public EventServiceImpl(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    @Override
    public Event getEventById(long eventId) {
        return eventDao.getEventById(eventId);
    }

    @Override
    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return eventDao.getEventsByTitle(title, pageSize, pageNum);
    }

    @Override
    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return eventDao.getEventsForDay(day, pageSize, pageNum);
    }

    @Override
    public Event createEvent(Event event) {
        return eventDao.createEvent(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventDao.updateEvent(event);
    }

    @Override
    public boolean deleteEvent(long eventId) {
        return eventDao.deleteEvent(eventId);
    }

}
