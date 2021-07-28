package com.example.PropertyHunt.service;

import com.example.PropertyHunt.model.*;
import com.example.PropertyHunt.repository.PropertyRepository;
import com.example.PropertyHunt.repository.UserRepository;
import com.example.PropertyHunt.repository.UserRepositoryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    PropertyRepository propertyRepository;

    @Override
    public void listProperty(Property property, int userId) {
        UserRepository userRepository = UserRepositoryFactory.getUserRepository(UserType.OWNER);
        Owner user = (Owner) userRepository.getUserById(userId);
        user.getListedProperties().add(property);
        propertyRepository.listProperty(property);
    }

    @Override
    public List<Property> searchProperties(SearchCriteria searchCriteria, int userId) {
        List<Property> properties = null;
        if (searchCriteria.getListingType() == ListingType.Buy) {
            properties = propertyRepository.getPropertiesForSale();
        } else if (searchCriteria.getListingType() == ListingType.Rent) {
            properties = propertyRepository.getPropertiesForRent();
        }
        return filterByCriteria(properties, searchCriteria);
    }

    @Override
    public void shortlistProperty(int userId, int propertyId) {
        UserRepository userRepository = UserRepositoryFactory.getUserRepository(UserType.BUYER);
        Buyer user = (Buyer) userRepository.getUserById(userId);
        Property property = propertyRepository.getPropertyById(propertyId);
        user.getShortlistedProperties().add(property);
    }

    @Override
    public void markPropertyAsSold(int userId, int propertyId) {
        UserRepository userRepository = UserRepositoryFactory.getUserRepository(UserType.OWNER);
        Owner owner = (Owner) userRepository.getUserById(userId);
        Property property = propertyRepository.getPropertyById(propertyId);
        property.setPropertyStatus(PropertyStatus.SOLD);
    }

    private List<Property> filterByCriteria(List<Property> properties, SearchCriteria searchCriteria) {
        List<Property> result = new ArrayList<Property>();
        for (Property property : properties) {
            if (property.getAddress() != null && searchCriteria.getLocation() != null) {
                if (property.getAddress().getAddressStr().equalsIgnoreCase(searchCriteria.getLocation())) {
                    continue;
                }
            }
            if (property.getNumberOfRooms() != 0 && searchCriteria.getNumberOfRooms() != 0) {
                if (!(property.getNumberOfRooms() == searchCriteria.getNumberOfRooms())) {
                    continue;
                }
            }
            if (property.getPrice() != 0 && searchCriteria.getPriceRange() != null) {
                if (!(property.getPrice() < searchCriteria.getPriceRange().getEnd())) {
                    continue;
                }
            }
            if (property.getSize() != null && searchCriteria.getSize() != null) {
                if (!(property.getSize().greaterThan(searchCriteria.getSize())))
                    continue;
            }

            result.add(property);
        }
        return result;
    }
}
