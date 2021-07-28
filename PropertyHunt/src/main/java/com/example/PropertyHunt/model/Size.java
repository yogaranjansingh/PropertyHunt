package com.example.PropertyHunt.model;

import com.example.PropertyHunt.config.CommonUtilities;

public class Size {

    SizeUnit unit;
    int value;

    public SizeUnit getUnit() {
        return unit;
    }

    public void setUnit(SizeUnit unit) {
        this.unit = unit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean greaterThan(Size size) {
        if(size==null)
            return false;

        return CommonUtilities.convertSizeToMeters(this) > CommonUtilities.convertSizeToMeters(size);
    }
}
