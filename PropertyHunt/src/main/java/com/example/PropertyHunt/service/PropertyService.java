package com.example.PropertyHunt.service;

import com.example.PropertyHunt.model.Property;
import com.example.PropertyHunt.model.SearchCriteria;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PropertyService {

    void listProperty(Property property, int userId);

    List<Property> searchProperties(SearchCriteria searchCriteria, int userId);

    void shortlistProperty(int userId, int propertyId);

    void markPropertyAsSold(int userId, int propertyId);

}
