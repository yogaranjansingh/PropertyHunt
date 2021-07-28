package com.example.PropertyHunt.repository;

import com.example.PropertyHunt.model.Owner;
import com.example.PropertyHunt.model.User;

import java.util.HashMap;
import java.util.Map;


public class OwnerRepository implements UserRepository{

    static Map<Integer, Owner> owners = new HashMap<Integer, Owner>();


    @Override
    public User getUserById(int userId) {
        return owners.get(userId);
    }

    @Override
    public void addUser(User user) {
       owners.put(user.getId(), (Owner) user);
    }

}
