package com.thoughtworks.step.bootcamp.measurements;

import com.sun.jdi.InvalidTypeException;
import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertEquals;

public class TemperatureTest {
    @Test
    public void shouldAssert100CelsiusEquals212Fahrenheit() {
        final Measurement hundredCelsius = Measurement.inCelsius(new BigDecimal(100));
        final Measurement twoHundredAndTwelveFahrenheit = Measurement.inFahrenheit(new BigDecimal(212));
        assertEquals(twoHundredAndTwelveFahrenheit,hundredCelsius);
        assertEquals(hundredCelsius,twoHundredAndTwelveFahrenheit);
    }

    @Test
    public void shouldAssert1CelsiusEquals33_8Fahrenheit() {
        final Measurement oneCelsius = Measurement.inCelsius(new BigDecimal(1));
        final Measurement thirtyThreePointEightFahrenheit = Measurement.inFahrenheit(new BigDecimal(33.8));
        assertEquals(thirtyThreePointEightFahrenheit,oneCelsius);
        assertEquals(oneCelsius,thirtyThreePointEightFahrenheit);
    }

    @Test (expected = InvalidTypeException.class)
    public void shouldNotAllowToAddTwoTemperatures() throws InvalidTypeException {
        final Measurement oneCelsius = Measurement.inCelsius(new BigDecimal(1));
        oneCelsius.add(oneCelsius);
    }
}

