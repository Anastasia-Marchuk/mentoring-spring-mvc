package com.mentoring.amarchuk.web;

import com.mentoring.amarchuk.facade.BookingFacade;
import com.mentoring.amarchuk.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;


@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    BookingFacade bookingFacade;

    @GetMapping("/allUsers")
    public String getAllUsers(Model model) {

        List<User> allUsers = bookingFacade.getAllUsers();
        LOGGER.debug("get all users => {}", allUsers);
        model.addAttribute("allUsers", allUsers);
        model.addAttribute("heading", "List of all users in DB");
        LOGGER.info("Method start. UserController (-- / --)");
        return "list_users";
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable("id") int id,Model model) {

        LOGGER.debug("get user with id => {}", id);
        User user=bookingFacade.getUserById(id);
        List<User> list=new LinkedList<>();
        list.add(user);
        model.addAttribute("allUsers",list);
        model.addAttribute("heading", "User with id "+id);
        LOGGER.info("Method start. UserController.");

        return "facade";
    }

    @GetMapping("/user/email")
    public String getUserByEmail(@RequestParam("email") String email,Model model) {

        LOGGER.debug("get user with => {}", email);
        User user=bookingFacade.getUserByEmail(email);
        List<User> list=new LinkedList<>();
        list.add(user);
        model.addAttribute("message",user.toString());
        model.addAttribute("allUsers",list);
        model.addAttribute("heading", "User with email "+email);
        LOGGER.info("Method start. UserController.");

        return "facade";
    }


    @GetMapping("/user/name")
    public String getUserByName(@RequestParam("name") String name,Model model) {

        LOGGER.debug("get user with name => {}", name);
        List<User> allUsers=bookingFacade.getUsersByName(name,1,1);
        model.addAttribute("allUsers",allUsers);
        model.addAttribute("heading", "User(s) with name "+name);
        LOGGER.info("Method start. UserController.");

        return "facade";
    }

    @GetMapping("/user/update")
    public String updateUser(@RequestParam("name") String name,@RequestParam("id") long id,@RequestParam("email") String email,Model model) {

        LOGGER.debug("Update user with id => {}", id);
        User changeUser=new User(id, name, email);
        User user=bookingFacade.updateUser(changeUser);
        model.addAttribute("message",user.toString());
        model.addAttribute("heading", "User(s) with name "+name);
        LOGGER.info("Method start. UserController.");

        return "facade";
    }

    @GetMapping("/updateUser")
    public String updateUserById(@RequestParam("name") String name,@RequestParam("id") long id,@RequestParam("email") String email,Model model) {

            LOGGER.debug("Create user with name ({}) and email ({})", name, email);
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setId(id);
            bookingFacade.updateUser(user);
           LOGGER.info("Method start. UserController.");
            return "redirect:/";

    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Model model) {
        LOGGER.debug("Update user with id ({}) ", id);
        model.addAttribute("user", id);
        LOGGER.info("Method start. UserController.");
        return "update_user";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id,Model model) {
        LOGGER.debug("Delete user with id ({}) ", id);
        bookingFacade.deleteUser(id);
        model.addAttribute("message","User with id "+id);
        model.addAttribute("allUsers",null);
        model.addAttribute("heading", "Delete: ");
        LOGGER.info("Method start. UserController.");
        return "facade";
    }


    @GetMapping("/create")
    public String name(@RequestParam("name") String name, @RequestParam("email") String email) {
        LOGGER.debug("Create user with name ({}) and email ({})", name, email);
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        bookingFacade.createUser(user);
        LOGGER.info("Method start. UserController.");
        return "redirect:/";
    }

    @GetMapping("/new")
    public String create() {

        LOGGER.debug("Create new user ");
        return "new_user";
    }


}
