package by.prohor.dao.impl.list;

import by.prohor.dao.UserDao;
import by.prohor.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Artsiom Prokharau 02.07.2021
 */

@Repository
public class UserDaoList implements UserDao {

    @Autowired
    private List<User> users;

    @Override
    public User getUserById(long userId) {
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
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
        return null;
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
