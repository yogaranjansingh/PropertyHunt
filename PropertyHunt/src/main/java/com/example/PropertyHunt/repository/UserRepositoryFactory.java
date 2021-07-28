package com.example.PropertyHunt.repository;

import com.example.PropertyHunt.model.UserType;

public class UserRepositoryFactory {

    public static UserRepository getUserRepository(UserType userType)
    {
        switch (userType) {
            case BUYER:
                return new BuyerRepository();

            case OWNER:
                return new OwnerRepository();

            default:
                return null;
        }
    }
}
