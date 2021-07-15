package com.mentoring.amarchuk.web;

import com.mentoring.amarchuk.facade.BookingFacade;
import com.mentoring.amarchuk.model.Category;
import com.mentoring.amarchuk.model.Event;
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
public class EventController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);

    BookingFacade bookingFacade;

    public EventController(BookingFacade bookingFacade) {
        this.bookingFacade = bookingFacade;
    }



    @GetMapping("/allEvents")
    public String getAllTickets(Model model) {
        LOGGER.debug("Get all tickets");
        List<Event> allEvents = bookingFacade.getAllEvents();
        model.addAttribute("allEvents", allEvents);
        model.addAttribute("heading", "List of all events in DB");
        return "list_events";
    }

}
