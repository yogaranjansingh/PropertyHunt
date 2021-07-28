package com.example.PropertyHunt.config;

import com.example.PropertyHunt.model.Size;

public class CommonUtilities {

    public static double convertFeetToMeters(int feet)
    {
        return feet*Constants.FEET_TO_METER_CONVERSION;
    }

    public static double convertYardsToMeter(int yards)
    {
        return yards*0.9144;
    }

    public static double convertSizeToMeters(Size size){
        double valueInMeter = 0;
        switch (size.getUnit())
        {
            case SQUARE_FEET:
                valueInMeter = convertFeetToMeters(size.getValue());
                break;
            case SQUARE_METER:
                break;
            case SQUARE_YARD:
                valueInMeter = convertYardsToMeter(size.getValue());
                break;
            default:
        }
        return valueInMeter;
    }
}
