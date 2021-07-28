package com.example.PropertyHunt.repository;

import com.example.PropertyHunt.model.Buyer;
import com.example.PropertyHunt.model.User;

import java.util.HashMap;
import java.util.Map;

public class BuyerRepository implements  UserRepository {

    static Map<Integer, Buyer> buyers = new HashMap<Integer, Buyer>();

    @Override
    public User getUserById(int userId) {
        return buyers.get(userId);
    }

    @Override
    public void addUser(User user) {
        buyers.put(user.getId(), (Buyer) user);
    }

}
