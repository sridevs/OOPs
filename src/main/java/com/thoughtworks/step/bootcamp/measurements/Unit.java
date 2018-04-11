package com.thoughtworks.step.bootcamp.measurements;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

enum Unit {
    FEET(new BigDecimal(1), Constants.LENGTH), INCH(new BigDecimal(12), Constants.LENGTH), CM(new BigDecimal(30), Constants.LENGTH), MM(new BigDecimal(300), Constants.LENGTH),
    LITRE(new BigDecimal(1), Constants.VOLUME), GALLON(new BigDecimal(0.26), Constants.VOLUME),
    KG(new BigDecimal(1), Constants.WEIGHT), GRAM(new BigDecimal(1000), Constants.WEIGHT), TON(new BigDecimal(0.001), Constants.WEIGHT),
    CELSIUS(new BigDecimal(1),Constants.TEMP),
    FAHRENHEIT(new BigDecimal(1.8),Constants.TEMP) {
        @Override
        public BigDecimal toUnit(BigDecimal valueInBase, BigDecimal value) {
            MathContext mathContext = new MathContext(4);
            return value.subtract(new BigDecimal(32)).multiply(new BigDecimal(0.5555555555555555)).round(mathContext);
        }
    };

    protected final BigDecimal valueInBase;
    protected final String type;

    Unit(BigDecimal valueInBase, String type) {
        this.valueInBase = valueInBase;
        this.type = type;
    }

    private static class Constants {
        static final String LENGTH = "LENGTH_FEET";
        static final String VOLUME = "VOLUME_LITRE";
        static final String WEIGHT = "WEIGHT_KG";
        static final String TEMP = "NONARITHMATIC_TEMPERATURE_CELSIUS";
    }

    public boolean isTypeDifferent(Unit unit2Name) {
        return !this.type.equals(unit2Name.type);
    }

    public BigDecimal toUnit(BigDecimal valueInBase, BigDecimal value){
        final BigDecimal unit1BaseValue = value.divide(this.valueInBase,3,RoundingMode.HALF_UP);
        MathContext mathContext = new MathContext(4);
        return valueInBase.multiply(unit1BaseValue).round(mathContext);
    }
}
