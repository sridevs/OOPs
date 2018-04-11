package com.thoughtworks.step.bootcamp.measurements;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class WeightTest {
    @Test
    public void shouldAssertOneKgEqualsThousandGrams() {
        Assert.assertEquals(Measurement.inKg(new BigDecimal(1)), Measurement.inGram(new BigDecimal(1000)));
    }

    @Test
    public void shouldAssertOneGramEqualsOneByThousandKg() {
        assertEquals(Measurement.inGram(new BigDecimal(1)), Measurement.inKg(new BigDecimal(0.001)));
    }

    @Test
    public void shouldAssertOneGallonNotEqualsOneKg() {
        assertNotEquals(Measurement.inGallon(new BigDecimal(1)), Measurement.inKg(new BigDecimal(1)));
    }

    @Test
    public void shouldAssertOneTonEqualsThousandKgs() {
        assertEquals(Measurement.inTon(new BigDecimal(1)), Measurement.inKg(new BigDecimal(1000)));
    }
}
