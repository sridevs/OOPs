package com.thoughtworks.step.bootcamp.parkingLot;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class ParkingLotsTest {
    private ParkingLots parkingLots;
    private ParkingLot parkingLot;
    @Before
    public void setUp() {
        parkingLots = new ParkingLots(new LotFilter());
        parkingLot = mock(ParkingLot.class);
        parkingLots.add(parkingLot);
    }

    @Test
    public void firstLot() {
        assertEquals(parkingLots.firstLot(),parkingLot);
    }

    @Test
    public void removeFirstLot() {
        ParkingLot parkingLot2 = mock(ParkingLot.class);
        parkingLots.add(parkingLot2);
        parkingLots.removeFirstLot();
        assertEquals(parkingLots.firstLot(),parkingLot2);
    }

    @Test
    public void availableLot() throws CantParkException {
        ParkingLot parkingLot2 = mock(ParkingLot.class);
        parkingLots.add(parkingLot2);
        assertEquals(parkingLots.availableLot(),parkingLot);
    }
}