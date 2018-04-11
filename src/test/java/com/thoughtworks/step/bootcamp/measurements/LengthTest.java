package com.thoughtworks.step.bootcamp.measurements;

import com.sun.jdi.InvalidTypeException;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

//ensures feet behaves as expected
public class LengthTest {
    @Test
    public void shouldCheckWhether1FeetIsEqualTo1Feet() {
        final Measurement feet = Measurement.inFeet(new BigDecimal(3));
        final Measurement feet2 = Measurement.inFeet(new BigDecimal(3));
        assertEquals(feet, feet2);
    }

    @Test
    public void shouldCheck1FeetIsEqualTo12Inch() {
        final Measurement oneFeet = Measurement.inFeet(new BigDecimal(5));
        final Measurement twelveInch = Measurement.inInch(new BigDecimal(60));
        assertEquals(oneFeet, twelveInch);
    }

    @Test
    public void shouldCheck2InchEqualTo5Cm() {
        final Measurement fiveCentimeters = Measurement.inCm(new BigDecimal(5));
        final Measurement twoInch = Measurement.inInch(new BigDecimal(2));
        assertEquals(fiveCentimeters, twoInch);
    }

    @Test
    public void shouldCheck1InchEqualToTwoAndHalfCm() {
        final Measurement fiveCentimeters = Measurement.inCm(new BigDecimal(2.5));
        final Measurement twoInch = Measurement.inInch(new BigDecimal(1));
        assertEquals(fiveCentimeters, twoInch);
    }

    @Test
    public void shouldCheck1CmEqualToTenMm() {
        final Measurement oneCentimeter = Measurement.inCm(new BigDecimal(1));
        final Measurement tenMm = Measurement.inMm(new BigDecimal(10));
        assertEquals(oneCentimeter, tenMm);
        assertEquals(oneCentimeter.hashCode(), tenMm.hashCode());
    }

    @Test
    public void shouldAssertFalseFor1CmEqualTo1Feet() {
        final Measurement oneCentimeter = Measurement.inFeet(new BigDecimal(1));
        final Measurement oneFeet = Measurement.inKg(new BigDecimal(1));
        assertNotEquals(oneCentimeter, oneFeet);
        assertNotEquals(oneCentimeter.hashCode(), oneFeet.hashCode());
    }

    @Test
    public void shouldAssert2InchPlus2InchEquals4Inch() throws InvalidTypeException {
        final Measurement twoInch = Measurement.inInch(new BigDecimal(2));
        final Measurement oneByThreeFeet = Measurement.inFeet(new BigDecimal(0.334));
        assertEquals(twoInch.add(twoInch),oneByThreeFeet);
    }

    @Test
    public void shouldAssert2InchPlusTwoPointFiveCmEquals3Inch() throws InvalidTypeException {
        final Measurement twoInch = Measurement.inInch(new BigDecimal(2));
        final Measurement threeInch = Measurement.inInch(new BigDecimal(3));
        final Measurement pointTwoFiveFeet = Measurement.inFeet(new BigDecimal(0.25));
        final Measurement twoPointFiveCm = Measurement.inCm(new BigDecimal(2.5));
        assertEquals(twoInch.add(twoPointFiveCm),pointTwoFiveFeet);
        assertEquals(twoPointFiveCm.add(twoInch),pointTwoFiveFeet);
        assertEquals(twoPointFiveCm.add(twoInch),threeInch);
    }

    @Test (expected = InvalidTypeException.class)
    public void shouldThrowInvalidTypeExceptionWhileTryingToAddInchWithLitre() throws InvalidTypeException {
        final Measurement oneLitre = Measurement.inLitre(new BigDecimal(1));
        final Measurement oneInch = Measurement.inInch(new BigDecimal(1));
        oneInch.add(oneLitre);
    }

    @Test
    public void oneCentimeterShouldBeConvertedToTenMM() {
        final Measurement oneCm = Measurement.inCm(new BigDecimal(1));
        final Measurement oneMm = Measurement.inMm(new BigDecimal(10));
        assertEquals(oneCm.toUnit(Unit.MM),oneMm);
    }
}
