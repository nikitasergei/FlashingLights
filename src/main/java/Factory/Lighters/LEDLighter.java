package Factory.Lighters;


import Factory.Battery.Accumulator;
import Factory.Battery.Battery;
import Factory.Factory;
import Factory.LightElements.LightElement;

public class LEDLighter extends LighterWithTwoBatteries {
    private Battery batteryThree;
    public static final int CHARGE_FOR_WORK = 3;


    public LEDLighter(LightElement lamp){
        this.batteryOne = getBattery(Factory.ACCUMULATOR);
        this.batteryTwo = getBattery(Factory.ACCUMULATOR);
        this.batteryThree = getBattery(Factory.ACCUMULATOR);
        this.lamp = lamp;

    }
    public boolean turnOn() {
        if (batteryOne.charge + batteryTwo.charge + batteryThree.charge >= LEDLighter.CHARGE_FOR_WORK) {
            if (!isOn) {
                this.batteryOne.looseLEDCharge();
                this.batteryTwo.looseLEDCharge();
                this.batteryThree.looseLEDCharge();
            }
            return (!isOn);
        } else
            return isOn;
    }

    public Accumulator getAccumulator() {
        if (!this.isOn) {
            if (this.batteryOne instanceof Accumulator && this.batteryOne.charge < 70)
                return (Accumulator) this.batteryOne;
            else if (this.batteryTwo instanceof Accumulator && this.batteryTwo.charge < 70)
                return (Accumulator) this.batteryTwo;
            else if (this.batteryThree instanceof Accumulator && this.batteryThree.charge < 70)
                return (Accumulator) this.batteryThree;
            else return null;
        } else
            return null;
    }
}
