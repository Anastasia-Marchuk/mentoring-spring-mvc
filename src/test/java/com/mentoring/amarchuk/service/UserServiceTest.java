//package com.mentoring.amarchuk.service;
//
//import com.mentoring.amarchuk.dao.UserDao;
//import com.mentoring.amarchuk.dao.UserDaoList;
//import com.mentoring.amarchuk.model.User;
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.Mockito.*;
//import java.util.List;
//
//public class UserServiceTest {
//
//    UserService userService = mock(UserService.class);
//    UserDao userDao=mock(UserDao.class);
//    UserDaoList userDaoListDBImpl =mock(UserDaoList.class);
//
//    private static User testUser;
//    private static List<User> listUsers=new ArrayList<>();
//
//
//    private static Logger logger = LoggerFactory.getLogger(UserServiceTest.class);
//
//    @Before
//    public void init() {
//        logger.info("Adding test user to list ");
//        testUser =  new User(1, "Stacy", "stacy@gmail.com");
//        listUsers.add(testUser);
//
//    }
//
//    @Test
//    public void testCreateUser() {
//        User user = new User(1, "Stacy", "stacy@gmail.com");
//        when(userService.createUser(user)).thenReturn(user);
//        assertEquals(user, user);
//    }
//
//    @Test
//    public void testGetUserByName() {
//        List<User> list = new ArrayList<>();
//        User user1 = new User(1, "Stacy Marchuk", "stacy@gmail.com");
//        list.add(user1);
//        listUsers.add(user1);
//    }
//
//            @Test
//            public void testDeleteUser() {
//
//                User user1 = new User(1, "Stacy", "stacy@gmail.com");
//                User user2 = new User(1, "Michail", "stacy@gmail.com");
//
//                listUsers.add(user1);
//                listUsers.add(user2);
//                when(userService.deleteUser(1)).thenReturn(true);
//                boolean result=userService.deleteUser(1);
//                assertEquals(true, result);
//            }
//            @Test
//            public void updateTest() {
//
//                when(userDao.getUserById(1)).thenReturn(testUser);
//                assertEquals(testUser,userDao.getUserById(1));
//                when(userDaoListDBImpl.getUserById(1)).thenReturn(testUser);
//                assertEquals(testUser, userDaoListDBImpl.getUserById(1));
//
//                User userForUpdate =  new User(1, "UpdatedStacy", "stacy@gmail.com");
//                testUser =  new User(1, "Stacy", "stacy@gmail.com");
//                testUser.setName("UpdatedStacy");
//
//                when(userService.updateUser(userForUpdate)).thenReturn(testUser);
//                User resultUser = userService.updateUser(userForUpdate);
//                assertTrue(resultUser.getName().equals(userForUpdate.getName()));
//                assertTrue("UpdatedStacy".equals(userForUpdate.getName()));
//            }
//        }
