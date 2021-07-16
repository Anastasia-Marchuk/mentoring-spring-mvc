package com.mentoring.amarchuk.service.parser;

import com.mentoring.amarchuk.model.Ticket;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;


@JacksonXmlRootElement(localName = "TicketDto")
public class TicketDto {

    @JacksonXmlProperty(localName = "listTickets")
    @JacksonXmlElementWrapper(useWrapping = false)
   private List<Ticket> listTickets;


    public TicketDto() {

    }

    public void setUsers(List<Ticket>  listTickets) {
        this.listTickets = listTickets;
    }

    @Override
    public String toString() {
        return "TicketDto{" +
                "tickets=" + listTickets +
                '}';
    }

    public List<Ticket> getTickets() {
        return listTickets;

    }
}
