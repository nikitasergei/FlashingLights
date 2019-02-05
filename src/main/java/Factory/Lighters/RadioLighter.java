package Factory.Lighters;

import Factory.Battery.Accumulator;
import Factory.Battery.Battery;
import Factory.Factory;
import Factory.LightElements.LightElement;
import Factory.Radio.Radio;


public class RadioLighter extends Factory {
    public Radio radio;
    public Lighter lighter;
    private boolean isOn = false;
    private static final int CHARGE_FOR_WORK_LIGHTER = 10;
    private static final int CHARGE_FOR_WORK_RADIO = 6;

    public RadioLighter(Radio radio, Lighter lighter) {
        this.radio = radio;
        this.lighter = lighter;

    }

    public boolean turnOnLighter() {
        if (this.radio.battery.charge + this.lighter.battery.charge >= RadioLighter.CHARGE_FOR_WORK_LIGHTER) {
            if (!this.lighter.isOn) {
                if (this.lighter.battery.charge > RadioLighter.CHARGE_FOR_WORK_LIGHTER) {
                    this.lighter.battery.looseCharge();
                    return (!this.lighter.isOn);
                } else {
                    if (this.lighter.battery.charge > 0) {
                        this.radio.battery.charge -= (RadioLighter.CHARGE_FOR_WORK_LIGHTER - this.lighter.battery.charge);
                        this.lighter.battery.charge = 0;
                        return (!this.lighter.isOn);
                    } else {
                        this.radio.battery.looseCharge();
                        return (!this.lighter.isOn);
                    }
                }
            } else
                return isOn;
        } else return isOn;
    }

    public boolean turnOnRadio() {
        if (this.radio.battery.charge + this.lighter.battery.charge >= RadioLighter.CHARGE_FOR_WORK_RADIO) {
            if (!this.radio.isOn){
                if (this.radio.battery.charge > RadioLighter.CHARGE_FOR_WORK_RADIO) {
                    this.radio.battery.looseRadioCharge();
                    return (!this.radio.isOn);
                } else {
                    if (this.radio.battery.charge > 0) {
                        this.lighter.battery.charge -= (RadioLighter.CHARGE_FOR_WORK_RADIO - this.radio.battery.charge);
                        this.radio.battery.charge = 0;
                        return (!this.radio.isOn);
                    } else {
                        this.lighter.battery.looseRadioCharge();
                        return (!this.radio.isOn);
                    }
                }
        } else
            return isOn;
    } else
        return isOn;
}

    public void turnOff() {
        this.isOn = false;

    }



}
