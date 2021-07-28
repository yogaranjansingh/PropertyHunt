package com.example.PropertyHunt.controller;

import com.example.PropertyHunt.model.Property;
import com.example.PropertyHunt.model.SearchCriteria;
import org.springframework.http.ResponseEntity;

public interface PropertyController {

    ResponseEntity listProperty(Property property, int userId);

    ResponseEntity searchProperties(SearchCriteria searchCriteria, int userId);

    ResponseEntity shortListProperty(int userId, int propertyId);

    ResponseEntity markPropertyAsSold(int userId, int propertyId);

}
