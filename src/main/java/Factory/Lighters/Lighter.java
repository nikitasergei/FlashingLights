package Factory.Lighters;


import Factory.Battery.Accumulator;
import Factory.Battery.Battery;
import Factory.Factory;
import Factory.LightElements.LightElement;


public class Lighter extends Factory implements Work {
    public boolean isOn = false;
    public Battery battery;
    private LightElement lamp;
    private static final int CHARGE_FOR_WORK = 10;

    public Lighter(Battery battery, LightElement lamp) {
        this.battery = battery;
        this.lamp = lamp;
    }


    public boolean turnOn() {
        if (battery.charge >= Lighter.CHARGE_FOR_WORK) {
            if (!isOn)
                this.battery.looseCharge();
            return (!isOn);
        } else
            return isOn;
    }

    public Accumulator getAccumulator() {
        if (!this.isOn && this.battery instanceof Accumulator) {
            return (Accumulator) this.battery;
        } else
            return null;
    }


    public void turnOff() {
        this.isOn = false;

    }


}
