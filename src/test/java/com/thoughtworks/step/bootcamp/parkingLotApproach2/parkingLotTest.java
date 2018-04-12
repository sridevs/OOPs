package com.thoughtworks.step.bootcamp.parkingLotApproach2;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class parkingLotTest {
    private ParkingLot parkingLot;
    private int car;

    @Before
    public void setUp() {
        parkingLot = new ParkingLot(1);
        car = 1;
   }

    @Test
    public void shouldParkACar() throws CantParkException {
        final int token = 1;
        assertThat(parkingLot.park(1,car),is(token));
    }

    @Test
    public void shouldParkTwoCars() throws CantParkException {
        final int car2 = 2;
        parkingLot = new ParkingLot(2);
        final int token = 1;
        final int token2 = 2;
        assertThat(parkingLot.park(1,car),is(token));
        assertThat(parkingLot.park(2,car2),is(token2));
    }

    @Test (expected = CantParkException.class)
    public void shouldNotParkSameCarTwice() throws CantParkException {
        final int token = 1;
        assertThat(parkingLot.park(1,car),is(token));
        assertThat(parkingLot.park(2,car),is(2));
    }

    @Test
    public void shouldCheckOutAParkedCarGivenItsToken() throws CantParkException, CarNotPresentException {
        final int token = parkingLot.park(1,car);
        final int checkedOutCar = parkingLot.checkOut(token);
        assertEquals(checkedOutCar,car);
    }

    @Test (expected = CarNotPresentException.class)
    public void shouldNotCheckOutIfCarIsNotPresent() throws CantParkException, CarNotPresentException {
        final int token = parkingLot.park(1,car);
        parkingLot.checkOut(token);
        parkingLot.checkOut(token);
    }

    @Test
    public void shouldInformLotIsFull() throws CantParkException {
        int car = 1;
        parkingLot.park(1,car);
        assertTrue(parkingLot.isLotFull());
    }

    @Test (expected = CantParkException.class)
    public void shouldNotAllowToParkIfLotIsFull() throws CantParkException {
        final int car2 = 2;
        parkingLot.park(1,car);
        parkingLot.park(2,car2);
    }
}