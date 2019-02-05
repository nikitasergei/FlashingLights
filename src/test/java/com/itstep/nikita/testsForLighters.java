package com.itstep.nikita;

import Factory.Battery.Accumulator;
import Factory.Factory;
import Factory.Lighters.LEDLighter;
import Factory.Lighters.Lighter;
import Factory.Lighters.LighterWithTwoBatteries;
import Factory.Lighters.RadioLighter;
import Factory.Radio.Radio;
import org.junit.Assert;
import org.junit.Test;


public class testsForLighters {


    private Factory factory = new Factory() {
    };

    //Tests for Lighter with different Batteries
    @Test
    public void chinaBatteryLighterTest() throws Exception {
        Lighter lighter = factory.lighter(Factory.CHINA_BATTERY, Factory.LAMP);

        for (int i = 0; i < 5; i++) {
            Assert.assertTrue(lighter.turnOn());
            lighter.turnOff();
        }
        Assert.assertFalse(lighter.turnOn());
    }

    @Test
    public void notChinaBatteryLighterTest() throws Exception {
        Lighter lighter = factory.lighter(Factory.NOT_CHINA_BATTERY, Factory.LAMP);

        for (int i = 0; i < 10; i++) {
            Assert.assertTrue(lighter.turnOn());
            lighter.turnOff();
        }
        Assert.assertFalse(lighter.turnOn());
    }

    @Test
    public void DuracellBatteryLighterTest() throws Exception {
        Lighter lighter = factory.lighter(Factory.DURACELL, Factory.LAMP);

        for (int i = 0; i < 50; i++) {
            Assert.assertTrue(lighter.turnOn());
            lighter.turnOff();
        }
        Assert.assertFalse(lighter.turnOn());
    }

    @Test
    public void accumulatorLighterTest() throws Exception {
        Lighter lighter = factory.lighter(Factory.ACCUMULATOR, Factory.LAMP);
        for (int i = 0; i < 4; i++) {
            Assert.assertTrue(lighter.turnOn());
            lighter.turnOff();
        }
        Accumulator accumulator;
        Assert.assertNotNull(accumulator = lighter.getAccumulator());
        System.out.println(accumulator.showCharge());
        accumulator.charging();
        Assert.assertEquals(70, accumulator.charge);

        for (int i = 0; i < 7; i++) {
            Assert.assertTrue(lighter.turnOn());
            lighter.turnOff();
        }
        Assert.assertFalse(lighter.turnOn());
        Assert.assertEquals(0, lighter.battery.charge);
        accumulator.charging();
        Assert.assertTrue(lighter.turnOn());
    }

    //Tests for Radio with different Batteries
    @Test
    public void chinaBatteryRadioTest() throws Exception {
        Radio radio = factory.radio(Factory.CHINA_BATTERY);

        for (int i = 0; i < 8; i++) {
            Assert.assertTrue(radio.turnOn());
            radio.turnOff();
        }
        Assert.assertFalse(radio.turnOn());
    }

    @Test
    public void notChinaBatteryRadioTest() throws Exception {
        Radio radio = factory.radio(Factory.NOT_CHINA_BATTERY);

        for (int i = 0; i < 16; i++) {
            Assert.assertTrue(radio.turnOn());
            radio.turnOff();
        }
        Assert.assertFalse(radio.turnOn());
    }

    @Test
    public void DuracellBatteryRadioTest() throws Exception {
        Radio radio = factory.radio(Factory.DURACELL);

        for (int i = 0; i < 83; i++) {
            Assert.assertTrue(radio.turnOn());
            radio.turnOff();
        }
        Assert.assertFalse(radio.turnOn());
    }

    @Test
    public void accumulatorRadioTest() throws Exception {
        Radio radio = factory.radio(Factory.ACCUMULATOR);
        for (int i = 0; i < 5; i++) {
            Assert.assertTrue(radio.turnOn());
            radio.turnOff();
        }
        Accumulator accumulator;
        Assert.assertNotNull(accumulator = radio.getAccumulator());
        System.out.println(accumulator.showCharge());
        accumulator.charging();
        Assert.assertEquals(70, accumulator.charge);

        for (int i = 0; i < 11; i++) {
            Assert.assertTrue(radio.turnOn());
            radio.turnOff();
        }
        Assert.assertFalse(radio.turnOn());
        accumulator.charging();
        Assert.assertTrue(radio.turnOn());
    }


    //Tests for LighterWithTwoBatteries with different Batteries
    @Test
    public void chinaBatteryLighterWTBTest() throws Exception {
        LighterWithTwoBatteries lighter = factory.lighter(Factory.CHINA_BATTERY, Factory.CHINA_BATTERY, Factory.LAMP);

        for (int i = 0; i < 10; i++) {
            Assert.assertTrue(lighter.turnOn());
            lighter.turnOff();
        }
        Assert.assertFalse(lighter.turnOn());
    }

    @Test
    public void notChinaBatteryLighterWTBTest() throws Exception {
        LighterWithTwoBatteries lighter = factory.lighter(Factory.NOT_CHINA_BATTERY, Factory.NOT_CHINA_BATTERY, Factory.LAMP);

        for (int i = 0; i < 20; i++) {
            Assert.assertTrue(lighter.turnOn());
            lighter.turnOff();
        }
        Assert.assertFalse(lighter.turnOn());
    }

    @Test
    public void DuracellBatteryLighterWTBTest() throws Exception {
        LighterWithTwoBatteries lighter = factory.lighter(Factory.DURACELL, Factory.DURACELL, Factory.LAMP);

        for (int i = 0; i < 100; i++) {
            Assert.assertTrue(lighter.turnOn());
            lighter.turnOff();
        }
        Assert.assertFalse(lighter.turnOn());
    }

    @Test
    public void accumulatorLighterWTBTest() throws Exception {
        LighterWithTwoBatteries lighter = factory.lighter(Factory.ACCUMULATOR, Factory.ACCUMULATOR, Factory.LAMP);
        for (int i = 0; i < 9; i++) {
            Assert.assertTrue(lighter.turnOn());
            lighter.turnOff();
        }
        Accumulator accumulator;
        Assert.assertNotNull(accumulator = lighter.getAccumulator());
        System.out.println(accumulator.showCharge());
        accumulator.charging();
        Assert.assertNotNull(accumulator = lighter.getAccumulator());
        System.out.println(accumulator.showCharge());
        accumulator.charging();
        Assert.assertEquals(70, accumulator.charge);

        for (int i = 0; i < 14; i++) {
            Assert.assertTrue(lighter.turnOn());
            lighter.turnOff();
        }
        Assert.assertFalse(lighter.turnOn());
        Assert.assertEquals(0, lighter.batteryOne.charge);
        Assert.assertEquals(0, lighter.batteryTwo.charge);
        accumulator.charging();
        Assert.assertTrue(lighter.turnOn());
    }

    //Tests for RadioLighter with two Accumulators

    @Test
    public void RadioLighterTest() throws Exception {
        RadioLighter radioLighter = factory.radioLighter();

        for (int i = 0; i < 8; i++) {
            Assert.assertTrue(radioLighter.turnOnLighter());
            Assert.assertTrue(radioLighter.turnOnRadio());
            radioLighter.turnOff();
        }

        Accumulator accumulator;
        Assert.assertNotNull(accumulator = radioLighter.radio.getAccumulator());
        System.out.println(accumulator.showCharge());
        accumulator.charging();
        Assert.assertEquals(70, accumulator.charge);
        Assert.assertNotNull(accumulator = radioLighter.lighter.getAccumulator());
        System.out.println(accumulator.showCharge());
        accumulator.charging();
        Assert.assertEquals(70, accumulator.charge);
    }


    //Tests for LEDLighter

    @Test
    public void LEDLighterTest() throws Exception {

        LEDLighter lighterLED = factory.lEDlighter(Factory.LED_LAMP);

        for (int i = 0; i < 70; i++) {
            Assert.assertTrue(lighterLED.turnOn());
            lighterLED.turnOff();
        }
        Accumulator accumulator;
        for (int i = 0; i < 3; i++) {
            Assert.assertNotNull(accumulator = lighterLED.getAccumulator());
            System.out.println(accumulator.showCharge());
            accumulator.charging();
            Assert.assertEquals(70, accumulator.charge);
        }
        Assert.assertTrue(lighterLED.turnOn());
        lighterLED.turnOff();
    }
}


