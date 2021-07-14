package com.mentoring.amarchuk.dao.impl.list;

import com.mentoring.amarchuk.dao.EventDao;
import com.mentoring.amarchuk.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class EventDaoList implements EventDao {

    @Autowired
    private List<Event> events;

    @Override
    public Event getEventById(long eventId) {
        return events.stream().filter(o -> o.getId() == eventId).findAny().get();
    }

    @Override
    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return events.stream().filter(o -> o.getTitle().equals(title)).collect(Collectors.toList());
    }

    @Override
    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return events.stream().filter(o -> o.getDate().equals(day)).collect(Collectors.toList());
    }

    @Override
    public Event createEvent(Event event) {
        events.add(event);
        return event;
    }

    @Override
    public Event updateEvent(Event event) {
        return events.get((int) event.getId());
    }

    @Override
    public boolean deleteEvent(long eventId) {
        Event event = events.get((int) eventId);
        return events.remove(event);
    }

    @Override
    public int size() {
        return events.size();
    }

}
