package com.thoughtworks.step.bootcamp.measurements;

import com.sun.jdi.InvalidTypeException;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class VolumeTest {
    @Test
    public void shouldAssert1LitreEqualsToZeroPointTwoSixGallon() {
        Assert.assertEquals(Measurement.inGallon(new BigDecimal(0.26)), Measurement.inLitre(new BigDecimal(1)));
    }
    @Test
    public void shouldAssert1GallonEqualsToThreePointSevenEightLitres() {
        assertEquals(Measurement.inGallon(new BigDecimal(1)), Measurement.inLitre(new BigDecimal(3.846)));
    }
    @Test
    public void shouldAssert1GallonNotEqualsToOneKg() {
        assertNotEquals(Measurement.inGallon(new BigDecimal(1)), Measurement.inKg(new BigDecimal(1)));
    }

    @Test
    public void shouldAssertThatOneGallonAddedToOneLitreIsFourPointSevenEightLiters() throws InvalidTypeException {
        final Measurement oneGallon = Measurement.inGallon(new BigDecimal(1));
        final Measurement oneLitre = Measurement.inLitre(new BigDecimal(1));
        final Measurement fourPointSevenEight = Measurement.inLitre(new BigDecimal(4.846));
        assertEquals(oneLitre.add(oneGallon),fourPointSevenEight);
    }
}


