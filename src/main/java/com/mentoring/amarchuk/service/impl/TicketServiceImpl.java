package by.prohor.service.impl;


import by.prohor.dao.TicketDao;
import by.prohor.model.Category;
import by.prohor.model.Event;
import by.prohor.model.Ticket;
import by.prohor.model.User;
import by.prohor.service.TicketService;

import java.util.List;

/**
 * Created by Artsiom Prokharau 02.07.2021
 */


public class TicketServiceImpl implements TicketService {

    TicketDao ticketDao;

    public TicketServiceImpl(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    @Override
    public Ticket bookTicket(long userId, long eventId, int place, Category category) {
        return ticketDao.bookTicket(userId, eventId, place, category);
    }

    @Override
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return ticketDao.getBookedTickets(user, pageSize, pageNum);
    }

    @Override
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return ticketDao.getBookedTickets(event, pageSize, pageNum);
    }

    @Override
    public boolean cancelTicket(long ticketId) {
        return ticketDao.cancelTicket(ticketId);
    }
}
