package com.thoughtworks.step.bootcamp.parkingLot;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
Å
public class MaxCapacityConstraintTest {
    private LotSelector maxCapacityConstraint;
    private ArrayList<ParkingLot> parkingLots;
    private ParkingLot parkingLot1;
    private ParkingLot parkingLot2;

    @Before
    public void setUp() {
        maxCapacityConstraint = new MaxCapacityConstraint();
        parkingLots = new ArrayList<>();
        parkingLot1 = mock(ParkingLot.class);
        parkingLot2 = mock(ParkingLot.class);
        when(parkingLot1.compareCapacity(parkingLot2)).thenReturn(1);
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
    }

    @Test
    public void shouldReturnLotWithMaxCapacity() {
        final ParkingLot actual = maxCapacityConstraint.getAvailableLot(parkingLots);
        assertEquals(actual,parkingLot1);
    }
}