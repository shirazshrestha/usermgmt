package edu.mum.service;

import edu.mum.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static List<User> userList = new ArrayList<User>();

    public void save(User user){
        userList.add(user);
    }

    public List<User> getAllUser() {
        return userList;
    }

    public User findUserByUserNameAndPassword(String username, String password) {
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public User findUserById(int id) {
        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public void deleteById(int id) {
        for (User user : userList) {
            if (user.getId() == id) {
                userList.remove(user);
            }
        }
    }

    public int generateId() {
        int maxId = 0;
        for (User user : userList) {
            if (user.getId() > maxId) {
                maxId = user.getId();
            }
        }
        return maxId + 1;
    }

    public void updateUserById(int id, User user) {
        for (User u : userList) {
            if (u.getId() == id) {
                u = user;
            }
        }
    }

}
