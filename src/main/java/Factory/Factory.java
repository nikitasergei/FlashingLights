package Factory;

import Factory.Battery.*;
import Factory.LightElements.LEDLamp;
import Factory.LightElements.Lamp;
import Factory.LightElements.LightElement;
import Factory.Lighters.LEDLighter;
import Factory.Lighters.Lighter;
import Factory.Lighters.LighterWithTwoBatteries;
import Factory.Lighters.RadioLighter;
import Factory.Radio.Radio;

public abstract class Factory implements CreateLighter {

    //batteries
    public static final char CHINA_BATTERY = 'C';
    public static final char NOT_CHINA_BATTERY = 'N';
    public static final char DURACELL = 'D';
    public static final char ACCUMULATOR = 'A';


    //lamps
    public static final char LAMP = 'L';
    public static final char LED_LAMP = 'D';

    //manufacture of Radio
    public Radio radio(char batteryType) {
        Battery battery = getBattery(batteryType);
        if (battery != null)
            return new Radio(battery);
        else return null;
    }

    //manufacture of LEDLighter
    public LEDLighter lEDlighter(char lampType) {

        LightElement lamp = getLightElement(lampType);
        Battery batteryOne = getBattery(ACCUMULATOR);
        Battery batteryTwo = getBattery(ACCUMULATOR);
        Battery batteryThree = getBattery(ACCUMULATOR);
        if (batteryOne != null && batteryTwo != null && batteryThree != null && lamp != null)
            return new LEDLighter(lamp);
        else return null;

    }

    //manufacture of Lighter With Two Batteries
    public LighterWithTwoBatteries lighter(char batteryTypeOne, char batteryTypeTwo, char lampType) {

        LightElement lamp = getLightElement(lampType);
        Battery batteryOne = getBattery(batteryTypeOne);
        Battery batteryTwo = getBattery(batteryTypeTwo);
        if (batteryOne != null && batteryTwo != null && lamp != null)
            return new LighterWithTwoBatteries(batteryOne, batteryTwo, lamp);
        else return null;

    }

    //manufacture of Lighter With Radio
    public RadioLighter radioLighter() {
        Radio radio = new Radio(getBattery(ACCUMULATOR));
        Lighter lighter = new Lighter(getBattery(ACCUMULATOR), getLightElement(LAMP));
        return new RadioLighter(radio, lighter);
    }

    //manufacture of Lighters
    public Lighter lighter(char batteryType, char lampType) {

        LightElement lamp = getLightElement(lampType);
        Battery battery = getBattery(batteryType);
        if (battery != null && lamp != null)
            return new Lighter(battery, lamp);
        else return null;

    }

    //choose BatteryType
    public Battery getBattery(char batteryType) {
        switch (batteryType) {
            case 'C':
                return new ChinaBattery();
            case 'N':
                return new NotChinaBattery();
            case 'D':
                return new Duracell();
            case 'A':
                return new Accumulator();

            default:
                return null;
        }
    }

    //choose Light Element Type
    public LightElement getLightElement(char lampType) {
        switch (lampType) {
            case 'L':
                return new Lamp();
            case 'D':
                return new LEDLamp();
            default:
                return null;
        }
    }

}
