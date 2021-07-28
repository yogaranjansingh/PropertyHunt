package com.example.PropertyHunt.controller;

import com.example.PropertyHunt.exception.InvalidUserActionException;
import com.example.PropertyHunt.model.*;
import com.example.PropertyHunt.repository.UserRepository;
import com.example.PropertyHunt.service.UserService;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserControllerImpl implements UserController{

    @Autowired
    UserService userService;


    @Override
    @PostMapping("/buyer")
    public ResponseEntity addBuyer(@RequestBody Buyer user) {
        System.out.println("user = " + user.toString());
        userService.addUser(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    @PostMapping("/owner")
    public ResponseEntity addOwner(@RequestBody Owner user) {
        System.out.println("user = " + user.toString());
        userService.addUser(user);
        return new ResponseEntity(HttpStatus.OK);
    }
    @Override
    @RequestMapping(path = "shortlisted")
    @GetMapping
    public ResponseEntity getShortLisProperties(int userId) {
        List<Property> properties = userService.getShortListedProperties(userId);
        return new ResponseEntity(properties, HttpStatus.OK);
    }

    @Override
    @RequestMapping(path = "sold")
    @GetMapping
    public ResponseEntity getSoldProperties(int userId) {
        List<Property> properties = userService.getSoldProperties(userId);
        return new ResponseEntity(properties, HttpStatus.OK);
    }

    @Override
    @GetMapping("/listed/{userId}")
    public ResponseEntity getListedProperties(@PathVariable("userId") int userId) throws InvalidUserActionException {
        List<Property> properties = userService.getListedProperties(userId);
        return new ResponseEntity(properties, HttpStatus.OK);
    }
}
