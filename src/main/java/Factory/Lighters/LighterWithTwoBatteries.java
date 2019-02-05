package Factory.Lighters;

import Factory.Battery.Accumulator;
import Factory.Battery.Battery;
import Factory.Factory;
import Factory.LightElements.LightElement;

public class LighterWithTwoBatteries extends Factory implements Work {
    public boolean isOn = false;
    public Battery batteryOne;
    public Battery batteryTwo;
    public LightElement lamp;
    private static final int CHARGE_FOR_WORK = 10;

    public LighterWithTwoBatteries(){

    }

    public LighterWithTwoBatteries(Battery batteryOne, Battery batteryTwo, LightElement lamp) {
        this.batteryOne = batteryOne;
        this.batteryTwo = batteryTwo;
        this.lamp = lamp;
    }


    public boolean turnOn() {
        if (batteryOne.charge + batteryTwo.charge >= LighterWithTwoBatteries.CHARGE_FOR_WORK) {
            if (!isOn) {
                this.batteryOne.looseCharges();
                this.batteryTwo.looseCharges();
            }
            return (!isOn);
        } else
            return isOn;
    }

    public Accumulator getAccumulator() {
        if (!this.isOn) {
            if (this.batteryOne instanceof Accumulator && this.batteryOne.charge < 70)
                return (Accumulator) this.batteryOne;
            else if (this.batteryTwo instanceof Accumulator)
                return (Accumulator) this.batteryTwo;
            else return null;
        } else
            return null;
    }


    public void turnOff() {
        this.isOn = false;

    }

}
