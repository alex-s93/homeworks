package com.alevel.homework18.cars;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class TestCarWrite {
    public static void main(String[] args) throws IOException {
        JsonBuilder jsonBuilder = new JsonBuilder();

        Car toyota = new Car("Toyota", "Camry", new String[]{"red", "blue"}, "km/h", 230, 3.5, 5400, "11.8:1", 5);
        File jsonFile = new File("src/resources/" + toyota.getBrand().toLowerCase() + "_" + toyota.getModel().toLowerCase() + ".json");

        Map<String, Object> map = mapConfigurator(toyota);

        jsonBuilder.createJsonFile(jsonFile, map);
    }

    private static Map<String, Object> mapConfigurator(Car car) {
        Map<String, Object> carInfo = new TreeMap<>();
        Map<String, Object> maxSpeedInfo = new TreeMap<>();
        Map<String, Object> engineInfo = new TreeMap<>();

        maxSpeedInfo.put("unit", car.getMaxSpeedUnit());
        maxSpeedInfo.put("value", car.getMaxSpeedValue());

        engineInfo.put("volume", car.getVolume());
        engineInfo.put("rpm", car.getRpm());
        engineInfo.put("compressionRatio", car.getCompressionRatio());

        carInfo.put("brand", car.getBrand());
        carInfo.put("model", car.getModel());
        carInfo.put("colors", car.getColors());
        carInfo.put("seatingCapacity", car.getSeatingCapacity());
        carInfo.put("maxSpeed", maxSpeedInfo);
        carInfo.put("engine", engineInfo);

        return carInfo;
    }
}
