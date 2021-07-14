package com.mentoring.amarchuk.service.impl;


import com.mentoring.amarchuk.dao.TicketDao;
import com.mentoring.amarchuk.model.Category;
import com.mentoring.amarchuk.model.Event;
import com.mentoring.amarchuk.model.Ticket;
import com.mentoring.amarchuk.model.User;
import com.mentoring.amarchuk.service.TicketService;

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
