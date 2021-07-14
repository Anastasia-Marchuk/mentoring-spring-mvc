package by.prohor.model;

import java.util.Date;
import java.util.Objects;

/**
 * Created by Artsiom Prokharau 02.07.2021
 */

public class Event {

    private long Id;
    private String title;
    private Date date;

    public Event(Long id, String title, Date date) {
        this.Id = id;
        this.title = title;
        this.date = date;
    }

    public Event() {
    }


    public long getId() {
        return Id;
    }

    public void setId(long id) {
        this.Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return getId() == event.getId() &&
                Objects.equals(getTitle(), event.getTitle()) &&
                Objects.equals(getDate(), event.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getDate());
    }

    @Override
    public String toString() {
        return "Event{" +
                "Id=" + Id +
                ", title='" + title + '\'' +
                ", date=" + date +
                '}';
    }
}
