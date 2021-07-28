package com.example.PropertyHunt.model;

import lombok.Data;

@Data
public class Property {
    static int counter = 100;
    private int id;
    private Address address;
    private String description;
    private ListingType listingType;
    private PropertyStatus propertyStatus;
    private int price;
    private int numberOfRooms;
    private Size size;

    public Property(Address address, String description, ListingType listingType, PropertyStatus propertyStatus, int price, int numberOfRooms, Size size) {
        this.id = counter++;
        this.address = address;
        this.description = description;
        this.listingType = listingType;
        this.propertyStatus = propertyStatus;
        this.price = price;
        this.numberOfRooms = numberOfRooms;
        this.size = size;
    }

    public Property() {
        this.id = counter++;
    }


    public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public Address getAddress() {
          return address;
     }

     public void setAddress(Address address) {
          this.address = address;
     }

     public String getDescription() {
          return description;
     }

     public void setDescription(String description) {
          this.description = description;
     }

     public ListingType getListingType() {
          return listingType;
     }

     public void setListingType(ListingType listingType) {
          this.listingType = listingType;
     }

     public PropertyStatus getPropertyStatus() {
          return propertyStatus;
     }

     public void setPropertyStatus(PropertyStatus propertyStatus) {
          this.propertyStatus = propertyStatus;
     }

     public int getPrice() {
          return price;
     }

     public void setPrice(int price) {
          this.price = price;
     }

     public int getNumberOfRooms() {
          return numberOfRooms;
     }

     public void setNumberOfRooms(int numberOfRooms) {
          this.numberOfRooms = numberOfRooms;
     }

    public Size getSize() {
        return size;
    }
}
