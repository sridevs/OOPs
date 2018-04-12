package com.thoughtworks.step.bootcamp.parkingLotApproach2;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AttendantTest {
    @Test
    public void shouldBeAbleToParkACarGivenAParkingLot() throws CantParkException {
        ParkingLot parkingLot = new ParkingLot(1);
        final Attendant attendant = new Attendant("someAttendant");
        attendant.addLot(parkingLot);
        int car = 1;
        int token = 1;
        assertThat(attendant.park(car),is(token));
    }

    @Test (expected = CantParkException.class)
    public void shouldNotParkACarGivenAllLotsAreFull() throws CantParkException {
        ParkingLot parkingLot = new ParkingLot(1);
        final Attendant attendant = new Attendant("someAttendant");
        attendant.addLot(parkingLot);
        attendant.addLot(new ParkingLot(2));
        int car1 = 1;
        int car2 = 2;
        int car3 = 3;
        attendant.park(car1);
        attendant.park(car2);
        attendant.park(car3);
        attendant.park(car3);
    }

    @Test
    public void shouldParkACarGivenSpaceInLastLot() throws CantParkException {
        ParkingLot parkingLot = new ParkingLot(1);
        final Attendant attendant = new Attendant("someone");
        attendant.addLot(parkingLot);
        attendant.addLot(new ParkingLot(1));
        int car1 = 1;
        int car2 = 2;
        attendant.park(car1);
        final int tokenGenerated = attendant.park(car2);
        assertEquals(tokenGenerated,2);
    }

    @Test
    public void shouldAcceptReporterAsAVisitor() throws IOException {
        final HtmlReporter mockHtmlReporter = mock(HtmlReporter.class);
        final Attendant someAttendant = new Attendant("someAttendant");
        someAttendant.accept(mockHtmlReporter);
        verify(mockHtmlReporter).generateReport(someAttendant);
    }

    @Test
    public void shouldGenerateReportOfLot() throws IOException {
        final HtmlReporter mockHtmlReporter = new HtmlReporter();
        final Attendant someAttendant = new Attendant("someAttendant");
        final ParkingLot parkingLot = new ParkingLot(1);
        final ParkingLot parkingLot2 = new ParkingLot(1);
        someAttendant.addLot(parkingLot);
        someAttendant.addLot(parkingLot2);
        final String report = someAttendant.accept(mockHtmlReporter);
        System.out.println(someAttendant.toString());
//        assertEquals(report,"Attendant name:someAttendant");
    }
}
