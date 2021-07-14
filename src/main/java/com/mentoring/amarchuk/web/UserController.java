package com.mentoring.amarchuk.web;

import com.mentoring.amarchuk.facade.BookingFacade;
import com.mentoring.amarchuk.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Artsiom Prokharau 09.07.2021
 */


@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    BookingFacade bookingFacade;

    public UserController(BookingFacade bookingFacade) {
        this.bookingFacade = bookingFacade;
    }

    @GetMapping("/allUsers")
    public String getAllUsers(Model model) {
        List<User> allUsers = bookingFacade.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        model.addAttribute("heading", "List of all users in DB");
        return "list_users";
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable("id") int id,Model model) {
        User user=bookingFacade.getUserById(id);
        List<User> list=new LinkedList<>();
        list.add(user);
        model.addAttribute("allUsers",list);
        model.addAttribute("heading", "User with id "+id);
        return "facade";
    }

    @GetMapping("/user/email")
    public String getUserByEmail(@RequestParam("email") String email,Model model) {
        User user=bookingFacade.getUserByEmail(email);
        List<User> list=new LinkedList<>();
        list.add(user);
        model.addAttribute("message",user.toString());
        model.addAttribute("allUsers",list);
        model.addAttribute("heading", "User with email "+email);
        return "facade";
    }


    @GetMapping("/user/name")
    public String getUserByName(@RequestParam("name") String name,Model model) {
        List<User> allUsers=bookingFacade.getUsersByName(name,1,1);
        model.addAttribute("allUsers",allUsers);
        model.addAttribute("heading", "User(s) with name "+name);
        return "facade";
    }

    @GetMapping("/user/update")
    public String updateUser(@RequestParam("name") String name,@RequestParam("id") long id,@RequestParam("email") String email,Model model) {
        User changeUser=new User(id, name, email);
        User user=bookingFacade.updateUser(changeUser);
        //  List<User> allUsers=bookingFacade.getUsersByName(name,1,1);
        //  model.addAttribute("allUsers",allUsers);
        model.addAttribute("message",user.toString());
        model.addAttribute("heading", "User(s) with name "+name);
        return "facade";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id,Model model) {
        bookingFacade.deleteUser(id);
        model.addAttribute("message","User with id "+id);
        model.addAttribute("allUsers",null);
        model.addAttribute("heading", "Delete: ");
        return "facade";
    }


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

    @GetMapping("/new")
    public String create() {
        return "new_user";
    }

//
////    @GetMapping("/")
////    public String start(Model model) {
////        List<User> allUsers = bookingFacade.getAllUsers();
////        LOGGER.debug("get all users => {}", allUsers);
////        model.addAttribute("allUser", allUsers);
////        LOGGER.info("Method start. UserController (-- / --)");
////        return "users";
////    }
//
//    @GetMapping("/create")
//    public String name(@RequestParam("name") String name, @RequestParam("email") String email) {
//        LOGGER.debug("Create user with name ({}) and email ({})", name, email);
//        User user = new User();
//        user.setName(name);
//        user.setEmail(email);
//        bookingFacade.createUser(user);
//        LOGGER.info("Method start. UserController (-- /create --)");
//        return "redirect:/";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable("id") int id) {
//        LOGGER.debug("Delete user with id ({})", id);
//        bookingFacade.deleteUser(id);
//        LOGGER.info("Method start. UserController (-- /delete/{id} --)");
//        return "redirect:/";
//    }
//
//    @GetMapping("/new")
//    public String create() {
//        LOGGER.info("Method start. UserController (-- /new --)");
//        return "user_add";
//    }

}
