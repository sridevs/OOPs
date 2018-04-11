package com.thoughtworks.step.bootcamp.parkingLot;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class AttendantTest {
    private ParkingLot parkingLot;
    @Before
    public void setUp() {
        parkingLot = new ParkingLot(1);
    }

    @Test
    public void shouldBeAbleToParkACarGivenAParkingLot() throws CantParkException {

        LotSelector lotFilter = new FirstAvailableLotConstraint();
        final Attendant attendant = new Attendant(lotFilter);
        attendant.addLot(parkingLot);
        int car = 1;
        int token = 1;
        assertThat(attendant.park(car),is(token));
    }

    @Test (expected = CantParkException.class)
    public void shouldNotParkACarGivenAllLotsAreFull() throws CantParkException {
        LotSelector lotFilter = new FirstAvailableLotConstraint();
        final Attendant attendant = new Attendant(lotFilter);
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
        LotSelector lotFilter = new FirstAvailableLotConstraint();
        final Attendant attendant = new Attendant(lotFilter);
        attendant.addLot(parkingLot);
        attendant.addLot(new ParkingLot(1));
        int car1 = 1;
        int car2 = 2;
        attendant.park(car1);
        final int tokenGenerated = attendant.park(car2);
        assertEquals(tokenGenerated,2);
    }

    @Test
    public void shouldParkCarInFirstAvailableLot() throws CantParkException {
        LotSelector firstAvailableLotConstraint = new FirstAvailableLotConstraint();
        final Attendant attendant = new Attendant(firstAvailableLotConstraint);
        ParkingLot parkingLot2 = new ParkingLot(2);
        ParkingLot parkingLot3 = new ParkingLot(3);
        attendant.addLot(parkingLot);
        attendant.addLot(parkingLot2);
        attendant.addLot(parkingLot3);
        int car1 = 1;
        int car2 = 2;
        int car3 = 3;
        int car4 = 4;
        attendant.park(car1);
        attendant.park(car2);
        attendant.park(car3);
        int token = attendant.park(car4);
        assertTrue(parkingLot3.hasCarOfToken(token));
    }

    @Test (expected = CantParkException.class)
    public void shouldThrowExceptionIfNoAvailableLots() throws CantParkException {
        LotSelector lotFilter = new FirstAvailableLotConstraint();
        final Attendant attendant = new Attendant(lotFilter);
        attendant.park(1);
    }

    @Test
    public void shouldParkCarInLotWithMaxCapacity() throws CantParkException {
        LotSelector maxCapacityConstraint = new MaxCapacityConstraint();
        final Attendant attendant = new Attendant(maxCapacityConstraint);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingLot parkingLot3 = new ParkingLot(2);
        attendant.addLot(parkingLot);
        attendant.addLot(parkingLot2);
        attendant.addLot(parkingLot3);
        int car = 1;
        int token = attendant.park(car);
        assertTrue(parkingLot3.hasCarOfToken(token));
    }

    @Test
    public void shouldGetLotWithMaxAvailability() throws CantParkException {
        final MaxVacancyConstraint maxVacancyConstraint = new MaxVacancyConstraint();
        final Attendant attendant = new Attendant(maxVacancyConstraint);
        ParkingLot parkingLot2 = new ParkingLot(12);
        ParkingLot parkingLot3 = new ParkingLot(2);
        attendant.addLot(parkingLot);
        attendant.addLot(parkingLot2);
        attendant.addLot(parkingLot3);
        int car1 = 1;
        int car2 = 2;
        int car3 = 3;
        final int token2 = attendant.park(car1);
        attendant.park(car2);
        int token = attendant.park(car3);
        assertTrue(parkingLot2.hasCarOfToken(token2));
    }

//    @Ignore
//    public void shouldCheckoutACarOfGivenToken() throws CantParkException {
//        final Attendant attendant = new Attendant();
//        ParkingLot parkingLot2 = new ParkingLot(1);
//        ParkingLot parkingLot3 = new ParkingLot(2);
//        attendant.addLot(parkingLot);
//        attendant.addLot(parkingLot2);
//        attendant.addLot(parkingLot3);
//        int car1 = 1;
//        attendant.park(car1);
//        int car2 = 2;
//        final int token = attendant.park(car2);
//        final int reqCar = attendant.checkout(token);
//        assertEquals(car2,reqCar);
//    }
}
