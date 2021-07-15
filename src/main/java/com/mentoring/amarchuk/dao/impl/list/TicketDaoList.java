package com.mentoring.amarchuk.dao.impl.list;

import com.mentoring.amarchuk.dao.TicketDao;
import com.mentoring.amarchuk.model.Category;
import com.mentoring.amarchuk.model.Event;
import com.mentoring.amarchuk.model.Ticket;
import com.mentoring.amarchuk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



@Repository
public class TicketDaoList implements TicketDao {

    @Autowired
    private Map<String, Ticket> tickets;

    @Override
    public Ticket bookTicket(long userId, long eventId, int place, Category category) {
        Ticket ticket = new Ticket(eventId, userId, category, place);
        ticket.setId(4);
        tickets.put("tickets: " + ticket.getId(), ticket);
        System.out.println(tickets);
        return ticket;
    }

    @Override
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        long id = user.getId();
        return tickets.values().stream().filter(o -> o.getUserId() == id).collect(Collectors.toList());
    }

    @Override
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return null;
    }

    @Override
    public boolean cancelTicket(long ticketId) {
        return tickets.keySet().removeIf(key -> key.equals("ticket" +ticketId));

    }

    @Override
    public int size() {
        return tickets.size();
    }

    @Override
    public List<Ticket> getAllTickets() {
        List <Ticket> list=new LinkedList<>();
        for (Map.Entry<String, Ticket> pair: tickets.entrySet())
        {
            list.add(pair.getValue());
        }
        return list;
    }

    @Override
    public void createTicket(Ticket ticket) {

        long newId=tickets.size()+1;
        ticket.setId(newId);
        tickets.put("ticket" + newId, ticket);

    }


//    @Override
//    public void preloadTickets(MultipartFile file) {
//
//    }

    public void preloadTickets(List<Ticket> list) {
//        for (int i = 0; i <list.size() ; i++) {
//            long newId=tickets.size()+1;
//            tickets.put("ticket" + newId, list.get(i));
//        }

        for (int i = 0; i <list.size() ; i++) {
            long newId=tickets.size()+1;
            tickets.put("ticket" + newId, list.get(i));
        }
    }


}
