package com.mentoring.amarchuk.web;

import com.mentoring.amarchuk.facade.BookingFacade;
import com.mentoring.amarchuk.model.Category;
import com.mentoring.amarchuk.model.Ticket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class TicketController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TicketController.class);

    BookingFacade bookingFacade;

    public TicketController(BookingFacade bookingFacade) {
        this.bookingFacade = bookingFacade;
    }

    @GetMapping("/")
    public String start(Model model) {
        model.addAttribute("message","Welcome!");
        model.addAttribute("question","What do you want to do?");
        return "welcome";
    }


    @GetMapping("/allTickets")
    public String getAllTickets(Model model) {
        List<Ticket> allTickets = bookingFacade.getAllTickets();
        model.addAttribute("allTickets", allTickets);
        model.addAttribute("heading", "List of all tickets in DB");
        return "list_tickets";
    }

    @GetMapping("/createTicket")
    public String createTicket(@RequestParam("eventId") long eventId, @RequestParam("userId") long userId,
                               @RequestParam("category") Category category, @RequestParam("place") int place) {
        Ticket ticket=new Ticket(eventId,userId,category, place);
        bookingFacade.createTicket(ticket);
        return "redirect:/";
    }

    @GetMapping("/deleteTicket/{id}")
    public String deleteTicket(@PathVariable("id") int id,Model model) {
        bookingFacade.cancelTicket(id);
        model.addAttribute("message","Ticket with id "+id);
        model.addAttribute("heading", "Delete: ");
        return "facade";
    }

    @GetMapping("/newTicket")
    public String createTicket() {
        return "new_ticket";
    }

}
