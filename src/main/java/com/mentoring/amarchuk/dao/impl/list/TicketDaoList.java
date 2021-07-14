package by.prohor.dao.impl.list;

import by.prohor.dao.TicketDao;
import by.prohor.model.Category;
import by.prohor.model.Event;
import by.prohor.model.Ticket;
import by.prohor.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Artsiom Prokharau 02.07.2021
 */

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
        return false;
    }

    @Override
    public int size() {
        return tickets.size();
    }


}
