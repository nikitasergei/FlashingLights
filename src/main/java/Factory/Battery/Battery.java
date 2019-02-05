package Factory.Battery;

import Factory.Factory;
import Factory.Lighters.LEDLighter;

public abstract class Battery extends Factory implements Chargeble {

    public int charge;


    public Battery(int charge) {
        this.charge = charge;
    }

    protected void setCharges(int charge) {
        this.charge = charge;
    }

    protected int getCharge() {
        return charge;
    }

    public void looseCharge() {
        this.charge -= 10;
    }
    public void looseRadioCharge() {
        this.charge -= 6;
    }
    public void looseCharges() {
        this.charge -= 5;
    }

    public void looseLEDCharge() {
        this.charge -= LEDLighter.CHARGE_FOR_WORK/3;
    }

    public boolean getCharge(int charge) {
        if (charge > 0 && this.charge >= charge) {
            this.charge -= charge;
            return true;
        }
        return false;
    }
}
