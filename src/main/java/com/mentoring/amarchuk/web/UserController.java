package com.mentoring.amarchuk.web;

import com.mentoring.amarchuk.facade.BookingFacade;
import com.mentoring.amarchuk.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    BookingFacade bookingFacade;

    public UserController(BookingFacade bookingFacade) {
        this.bookingFacade = bookingFacade;
    }

//    @GetMapping("/")
//    public String start(Model model) {
//        List<User> allUsers = bookingFacade.getAllUsers();
//        LOGGER.debug("get all users => {}", allUsers);
//        model.addAttribute("allUser", allUsers);
//        LOGGER.info("Method start. UserController (-- / --)");
//        return "users";
//    }

    @GetMapping("/create")
    public String name(@RequestParam("name") String name, @RequestParam("email") String email) {
        LOGGER.debug("Create user with name ({}) and email ({})", name, email);
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        bookingFacade.createUser(user);
        LOGGER.info("Method start. UserController (-- /create --)");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        LOGGER.debug("Delete user with id ({})", id);
        bookingFacade.deleteUser(id);
        LOGGER.info("Method start. UserController (-- /delete/{id} --)");
        return "redirect:/";
    }

    @GetMapping("/new")
    public String create() {
        LOGGER.info("Method start. UserController (-- /new --)");
        return "user_add";
    }

}
