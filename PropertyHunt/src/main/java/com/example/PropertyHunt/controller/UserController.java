package com.example.PropertyHunt.controller;

import com.example.PropertyHunt.exception.InvalidUserActionException;
import com.example.PropertyHunt.model.Buyer;
import com.example.PropertyHunt.model.Owner;
import org.springframework.http.ResponseEntity;

public interface UserController {

    ResponseEntity addOwner(Owner user);
    ResponseEntity addBuyer(Buyer user);

    ResponseEntity getShortLisProperties(int userId);

    ResponseEntity getSoldProperties(int userId);

    ResponseEntity getListedProperties(int userId) throws InvalidUserActionException;
}
