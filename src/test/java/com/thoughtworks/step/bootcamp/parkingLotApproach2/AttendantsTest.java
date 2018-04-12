package com.thoughtworks.step.bootcamp.parkingLotApproach2;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AttendantsTest {
    private Attendants attendants;
    private Attendant attendant;
    private Attendant attendant2;

    @Before
    public void setUp() {
        attendants = new Attendants();
        attendant = mock(Attendant.class);
        when(attendant.toString()).thenReturn("attendReport1");
        attendant2 = mock(Attendant.class);
        when(attendant2.toString()).thenReturn("attendReport2");
        attendants.addAttendant(attendant);
        attendants.addAttendant(attendant2);
    }

    @Test
    public void shouldReportDetailsOfAllAttendants() throws IOException {
        attendants.accept(new HtmlReporter());
    }
}
