package com.mentoring.amarchuk;

import com.mentoring.amarchuk.model.Category;
import com.mentoring.amarchuk.model.User;
import com.mentoring.amarchuk.facade.BookingFacadeImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AppSpring {


    private static final Logger logger =
            LoggerFactory.getLogger(AppSpring.class);

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("configSpring.xml");
        BookingFacadeImpl bean = applicationContext.getBean("facadeImpl",BookingFacadeImpl.class);
        logger.info("Printing ivents with eventId=2");

        System.out.println("Ivents with eventId=2:\n"+bean.getEventById(2)+"\n");

        logger.info("Printing tickets booked be user with id=1");
        User user = new User();
        user.setId(1);
        System.out.println("Tickets booked by userId=1:\n"+bean.getBookedTickets(user,1,1)+"\n");
        System.out.println("Book ticket for userId=2:\n"+bean.bookTicket(2, 2, 21, Category.PREMIUM)+"\n");
        System.out.println("Book ticket for userId=3:\n"+bean.bookTicket(3, 2, 21, Category.PREMIUM)+"\n");

        User user2=new User(10, "stacy","stacy@gmail.com");
        bean.createUser(user2);
        logger.info("Creating new user "+user2.getName());

        System.out.println("Data about user Stacy:\n"+bean.getUsersByName("Stacy",1,1)+"\n");

        System.out.println("Get user's data by Alex:\n"+bean.getUsersByName("Alex", 1, 1)+"\n");

     //   System.out.println("Get user's data by id=1:\n"+bean.getUserById(1)+"\n");

        System.out.println("Cancel ticket with id=4:\n"+bean.cancelTicket(4)+"\n");

        System.out.println("Delete all events:\n"+ bean.deleteAllEvents()+"\n");


    }
}