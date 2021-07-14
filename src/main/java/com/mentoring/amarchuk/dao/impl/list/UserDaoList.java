package com.mentoring.amarchuk.dao.impl.list;

import com.mentoring.amarchuk.dao.UserDao;
import com.mentoring.amarchuk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;


@Repository
public class UserDaoList implements UserDao {
    @Autowired
    private List<User> users;

    @Override
    public User getUserById(long userId) {
        return users.stream().filter(o -> o.getId()==userId).findAny().get();
    }

    @Override
    public User getUserByEmail(String email) {
        return users.stream().filter(o -> o.getEmail() == email).findAny().get();
    }

    @Override
    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return users.stream().filter(o -> o.getName().equals(name)).collect(Collectors.toList());
    }

    @Override
    public User createUser(User user) {
        users.add(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        users.remove(users.stream().filter(o -> o.getId() == user.getId()).collect(Collectors.toList()).get(0));
        users.add(user);
        return users.get((int) user.getId());
    }

    @Override
    public boolean deleteUser(long userId) {
        return users.remove(users.stream().filter(o -> o.getId() == userId).collect(Collectors.toList()).get(0));
    }

    @Override
    public int size() {
        return users.size();
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public void preloadUsers(List<User> list) {
        users.addAll(list);
    }
}
