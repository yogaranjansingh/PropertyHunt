package com.example.PropertyHunt.repository;

import com.example.PropertyHunt.model.Property;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PropertyRepository {
    public static List<Property> propertiesForSale = new ArrayList<Property>();
    public static List<Property> propertiesForRent = new ArrayList<Property>();
    public static Map<Integer, Property> propertyMap = new HashMap<Integer, Property>();

    public void listProperty(Property property) {
        switch (property.getListingType())
        {
            case Sell:
                propertiesForSale.add(property);
                break;
            case Rent:
                propertiesForRent.add(property);
            default:
                System.out.println("Default");
        }
    }

    public static List<Property> getPropertiesForSale() {
        return propertiesForSale;
    }

    public static List<Property> getPropertiesForRent() {
        return propertiesForRent;
    }

    public Property getPropertyById(int propertyId) {
        return propertyMap.get(propertyId);
    }
}
