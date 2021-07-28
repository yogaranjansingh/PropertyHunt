package com.example.PropertyHunt.service;

import com.example.PropertyHunt.exception.InvalidUserActionException;
import com.example.PropertyHunt.model.*;
import com.example.PropertyHunt.repository.UserRepository;
import com.example.PropertyHunt.repository.UserRepositoryFactory;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Override
    public void addUser(User user) {
        UserRepository userRepository = UserRepositoryFactory.getUserRepository(user.getUserType());
        userRepository.addUser(user);
    }

    @Override
    public User getUserById(int userId, UserType userType) {
        UserRepository userRepository = UserRepositoryFactory.getUserRepository(userType);
        userRepository.getUserById(userId);
        return userRepository.getUserById(userId);
    }

    @Override
    public List<Property> getShortListedProperties(int userId) {
        UserRepository userRepository = UserRepositoryFactory.getUserRepository(UserType.BUYER);
        Buyer user = (Buyer) userRepository.getUserById(userId);
        return user.getShortlistedProperties();
    }

    @Override
    public List<Property> getSoldProperties(int userId) {
        UserRepository userRepository = UserRepositoryFactory.getUserRepository(UserType.OWNER);
        Owner owner = (Owner) userRepository.getUserById(userId);
        List<Property> listedProperties = owner.getListedProperties();
        return listedProperties.stream().filter(a -> a.getPropertyStatus() == PropertyStatus.SOLD).collect(Collectors.toList());
    }

    @Override
    public List<Property> getListedProperties(int userId) throws InvalidUserActionException {
        UserRepository userRepository = UserRepositoryFactory.getUserRepository(UserType.OWNER);
        User user = userRepository.getUserById(userId);
        if(user.getUserType()==UserType.OWNER) {
            System.out.println("user = "+user.toString());
            List<Property> listedProperties =  ((Owner) user).getListedProperties();
            return listedProperties;
        }
        else {
            throw new InvalidUserActionException("wrong user type");
        }
    }
}
