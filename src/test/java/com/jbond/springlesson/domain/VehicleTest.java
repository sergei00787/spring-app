package com.jbond.springlesson.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    @Test
    public void testConstructor() {
        Vehicle vehicle = new Vehicle("VEHNAME");
        assertEquals("VEHNAME", vehicle.getVehName());
    }

}