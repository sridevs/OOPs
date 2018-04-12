package com.thoughtworks.step.bootcamp.parkingLotApproach2;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HtmlReporterTest {
    @Test
    public void shouldGenerateHtmlReport() throws IOException {
        final HtmlReporter htmlReporter = new HtmlReporter();
        final Attendant mockAttendant = mock(Attendant.class);
        when(mockAttendant.toString()).thenReturn("report");
        final String actual = htmlReporter.generateReport(mockAttendant);
//        assertEquals(actual, "<h1>Attendant report:report</h1>");
    }
}
