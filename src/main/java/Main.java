//import com.mentoring.amarchuk.facade.BookingFacadeImpl;
//import com.mentoring.amarchuk.model.Category;
//import com.mentoring.amarchuk.model.User;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
///**
// * Created by Artsiom Prokharau 02.07.2021
// */
//
//public class Main {
//    public static void main(String[] args) {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("WEB-INF/configSpring.xml");
//        BookingFacadeImpl bean = applicationContext.getBean("facadeImpl", BookingFacadeImpl.class);
////        Get from list Event
//        System.out.println(bean.getEventById(2));
//
//        String s = "3223,31";
//        double d = Double.parseDouble(s);
//
////        Get value from Map Ticket
//        User user = new User();
//        user.setId(1);
//        System.out.println(bean.getBookedTickets(user, 1, 1));
//
//        System.out.println(bean.bookTicket(2, 2, 21, Category.PREMIUM));
//
////        Get value from list User
//        System.out.println(bean.getUsersByName("Alex", 1, 1));
//
////
//
//    }
//}
