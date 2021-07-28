package com.example.PropertyHunt.model;

public class SearchCriteria {

    private String location;
    private PriceRange priceRange;
    private ListingType listingType;
    private int numberOfRooms;
    private Size size;
    private SortBy sortBy;


    public PriceRange getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(PriceRange priceRange) {
        this.priceRange = priceRange;
    }

    public ListingType getListingType() {
        return listingType;
    }

    public void setListingType(ListingType listingType) {
        this.listingType = listingType;
    }

    public String getLocation() {
        return location;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public SortBy getSortBy() {
        return sortBy;
    }

    public void setSortBy(SortBy sortBy) {
        this.sortBy = sortBy;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
