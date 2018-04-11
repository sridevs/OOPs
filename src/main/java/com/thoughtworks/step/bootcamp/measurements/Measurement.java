package com.thoughtworks.step.bootcamp.measurements;


import com.sun.jdi.InvalidTypeException;

import java.math.BigDecimal;

import static java.util.Objects.hash;

public class Measurement {
    private final BigDecimal value;
    private final Unit unit;

    private Measurement(BigDecimal value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public static Measurement inFeet(BigDecimal value) {
        return new Measurement(value, Unit.FEET);
    }

    public static Measurement inInch(BigDecimal value) {
        return new Measurement(value, Unit.INCH);
    }

    public static Measurement inCm(BigDecimal value) {
        return new Measurement(value, Unit.CM);
    }

    public static Measurement inMm(BigDecimal value) {
        return new Measurement(value, Unit.MM);
    }

    public static Measurement inLitre(BigDecimal value) {
        return new Measurement(value, Unit.LITRE);
    }

    public static Measurement inGallon(BigDecimal value) {
        return new Measurement(value, Unit.GALLON);
    }

    public static Measurement inKg(BigDecimal value) {
        return new Measurement(value, Unit.KG);
    }

    public static Measurement inGram(BigDecimal value) {
        return new Measurement(value, Unit.GRAM);
    }

    public static Measurement inTon(BigDecimal value) {
        return new Measurement(value, Unit.TON);
    }

    public static Measurement inCelsius(BigDecimal value) {return new Measurement(value,Unit.CELSIUS); }
    public static Measurement inFahrenheit(BigDecimal value) {
        return new Measurement(value,Unit.FAHRENHEIT);
    }

    @Override
    public String toString() {
        return "Quantity{" +
                "value=" + value +
                ", valueInBase=" + unit +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Measurement)) return false;
        Measurement physicalQuantity = (Measurement) o;
        System.out.println(physicalQuantity.unit.toUnit(new BigDecimal(1),physicalQuantity.value));
        System.out.println(unit.toUnit(new BigDecimal(1),value));
        return !unit.isTypeDifferent(physicalQuantity.unit) &&
        unit.toUnit(new BigDecimal(1),value)
                .equals(physicalQuantity.unit.toUnit(new BigDecimal(1),physicalQuantity.value));
    }

    @Override
    public int hashCode() {
        return hash(value.divide(unit.valueInBase,3), unit.type);
    }

    public Measurement add(Measurement measurement) throws InvalidTypeException {
        if (unit.isTypeDifferent(measurement.unit)) {
            throw new InvalidTypeException();
        }
        if (unit.type.startsWith("NONARITHMATIC")) throw new InvalidTypeException();
        final BigDecimal sum = unit.toUnit(new BigDecimal(1),value)
                .add(measurement.unit.toUnit(new BigDecimal(1),measurement.value));
        return new Measurement(sum, Unit.valueOf(unit.type.split("_")[1]));
    }

    public Measurement toUnit(Unit reqUnit) {
        final BigDecimal convertedValue = unit.toUnit(reqUnit.valueInBase, value);
        return new Measurement(convertedValue, reqUnit);
    }

}

