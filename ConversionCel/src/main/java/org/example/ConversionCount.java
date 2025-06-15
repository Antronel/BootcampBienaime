package org.example;

public class ConversionCount {
    private double farenheit = 82;
    private double celcius;
    //(32°F − 32) × 5/9 = 0°C
    public double convertFarenheitToCelcius(){
        return (farenheit - 32) * 5/9;
    }

}
