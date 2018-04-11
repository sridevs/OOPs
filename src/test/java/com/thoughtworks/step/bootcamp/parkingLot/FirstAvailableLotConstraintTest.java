package com.thoughtworks.step.bootcamp.parkingLot;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class FirstAvailableLotConstraintTest {
    private LotSelector lotConstraint;
    private ArrayList<ParkingLot> parkingLots;
    private ParkingLot parkingLot1;

    @Before
    public void setUp() {
        lotConstraint = new FirstAvailableLotConstraint();
        parkingLots = new ArrayList<>();
        parkingLot1 = mock(ParkingLot.class);
        ParkingLot parkingLot2 = mock(ParkingLot.class);
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
    }

    @Test
    public void shouldReturnTheFirstLotInAGivenListOfLots() {
        final ParkingLot actual = lotConstraint.getAvailableLot(parkingLots);
        assertEquals(actual,parkingLot1);
    }
}