package com.example.PropertyHunt.controller;

import com.example.PropertyHunt.model.Property;
import com.example.PropertyHunt.model.SearchCriteria;
import com.example.PropertyHunt.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertyControllerImpl implements PropertyController{

    @Autowired
    PropertyService propertyService;

    @Override
    @RequestMapping(path = "/list")
    @PostMapping
    public ResponseEntity listProperty(@RequestBody Property property, @RequestParam("userId") int userId) {
        System.out.println("property = " + property);
            propertyService.listProperty(property, userId);
            return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    @RequestMapping(path = "search")
    @GetMapping
    public ResponseEntity searchProperties(SearchCriteria searchCriteria, int userId) {
        List<Property> properties = propertyService.searchProperties(searchCriteria,userId);
        return new ResponseEntity(properties, HttpStatus.OK);
    }

    @Override
    @RequestMapping(path = "/shortlist")
    @PutMapping
    public ResponseEntity shortListProperty(int userId, int propertyId) {
       propertyService.shortlistProperty(userId, propertyId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    @RequestMapping(path = "/markSold")
    @PutMapping
    public ResponseEntity markPropertyAsSold(int userId, int propertyId) {
        propertyService.markPropertyAsSold(userId, propertyId);
        return new ResponseEntity(HttpStatus.OK);
    }



}
