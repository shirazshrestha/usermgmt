package edu.mum.service;

import edu.mum.domain.User;

import java.util.List;

public interface UserService {

    public void save(User user);

    public List<User> getAllUser();

    public User findUserByUserNameAndPassword(String username, String password);

    public User findUserById(int id);

    public void deleteById(int id);

    public int generateId();

    public void updateUserById(int id, User user);
}
