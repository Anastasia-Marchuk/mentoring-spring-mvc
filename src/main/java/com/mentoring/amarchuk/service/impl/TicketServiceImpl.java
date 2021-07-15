package com.mentoring.amarchuk.service.impl;


import com.mentoring.amarchuk.dao.TicketDao;
import com.mentoring.amarchuk.model.Category;
import com.mentoring.amarchuk.model.Event;
import com.mentoring.amarchuk.model.Ticket;
import com.mentoring.amarchuk.model.User;
import com.mentoring.amarchuk.service.TicketService;
import com.mentoring.amarchuk.service.parser.Jackson;
import com.mentoring.amarchuk.service.parser.TicketDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;


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

    @Override
    public List<Ticket> getAllTickets() {
        return ticketDao.getAllTickets();
    }

    @Override
    public void createTicket(Ticket ticket) {
        ticketDao.createTicket(ticket);
    }

    public void preloadTickets(MultipartFile file) {

        TicketDto ticketDto = null;
        try {
            ticketDto = new Jackson(file).loaderXmlFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Ticket> tickets=ticketDto.getTickets();
        //Map<String, Ticket> tickets = ticketDto.getTickets();
        ticketDao.preloadTickets(tickets);
    }


}
