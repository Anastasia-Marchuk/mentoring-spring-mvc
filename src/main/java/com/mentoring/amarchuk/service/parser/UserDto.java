package by.prohor.service.parser;

import by.prohor.model.User;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

/**
 * Created by Artsiom Prokharau 12.07.2021
 */

@JacksonXmlRootElement(localName = "UserDto")
public class UserDto {

    @JacksonXmlProperty(localName = "listUsers")
    @JacksonXmlElementWrapper(useWrapping = false)
   private ArrayList<User> listUsers;


    public UserDto() {
    }

    public ArrayList<User> getUsers() {
        return listUsers;
    }

    public void setUsers(ArrayList<User> list) {
        this.listUsers = list;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "users=" + listUsers +
                '}';
    }
}
