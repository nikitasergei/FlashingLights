package Factory.Radio;

import Factory.Battery.Accumulator;
import Factory.Battery.Battery;
import Factory.Factory;
import Factory.Lighters.Work;

public class Radio extends Factory implements Work {
    public boolean isOn = false;
    public Battery battery;
    private static final int CHARGE_FOR_WORK = 6;   //use 6 charges

    //create Radio
    public Radio(Battery battery) {
        this.battery = battery;
    }

    public boolean turnOn() {
        if (battery.charge >= Radio.CHARGE_FOR_WORK) {
            if (!isOn)
                this.battery.looseRadioCharge();
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
