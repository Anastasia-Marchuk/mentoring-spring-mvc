package com.mentoring.amarchuk.service;


import com.mentoring.amarchuk.dao.UserDao;
import com.mentoring.amarchuk.model.User;
import com.mentoring.amarchuk.service.UserService;
import com.mentoring.amarchuk.service.parser.Jackson;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public class UserServiceImpl implements UserService {

    UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUserById(long userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return userDao.getUsersByName(name, pageSize, pageNum);
    }

    @Override
    public User createUser(User user) {
        return userDao.createUser(user);
    }

    @Override
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public boolean deleteUser(long userId) {
        return userDao.deleteUser(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

//    public void preloadUsers(MultipartFile file) {
//        UserDto userDto = null;
//        try {
//            userDto = new Jackson(file).loaderXmlFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        List<User> users = userDto.getUsers();
//        userDao.preloadUsers(users);
//    }
}
