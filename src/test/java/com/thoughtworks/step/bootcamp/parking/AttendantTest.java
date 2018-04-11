package com.thoughtworks.step.bootcamp.parking;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AttendantTest {
    @Test
    public void shouldBeAbleToParkACarGivenAParkingLot() throws CantParkException {
        ParkingLot parkingLot = new ParkingLot(1);
        final Attendant attendant = new Attendant();
        attendant.addLot(parkingLot);
        int car = 1;
        int token = 1;
        assertThat(attendant.park(car),is(token));
    }

    @Test (expected = CantParkException.class)
    public void shouldNotParkACarGivenAllLotsAreFull() throws CantParkException {
        ParkingLot parkingLot = new ParkingLot(1);
        final Attendant attendant = new Attendant();
        attendant.addLot(parkingLot);
        attendant.addLot(new ParkingLot(1));
        int car1 = 1;
        int car2 = 2;
        int car3 = 3;
        attendant.park(car1);
        attendant.park(car2);
        attendant.park(car3);
    }

    @Test
    public void shouldParkACarGivenSpaceInLastLot() throws CantParkException {
        ParkingLot parkingLot = new ParkingLot(1);
        final Attendant attendant = new Attendant();
        attendant.addLot(parkingLot);
        attendant.addLot(new ParkingLot(1));
        int car1 = 1;
        int car2 = 2;
        attendant.park(car1);
        final int tokenGenerated = attendant.park(car2);
        assertEquals(tokenGenerated,2);
    }
}
