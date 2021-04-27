package com.jbond.springlesson.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    @Test
    public void testConstructor() {
        List<Property> propertyList= new ArrayList<>();
        Property prop = new Property("PropTest","String");
        propertyList.add(prop);
        Vehicle vehicle = new Vehicle("VEHNAME", propertyList);
        assertEquals("VEHNAME", vehicle.getVehName());
    }

}