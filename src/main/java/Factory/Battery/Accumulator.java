package Factory.Battery;

import Factory.Lighters.Lighter;

public class Accumulator extends Battery implements Accum {


    public Accumulator() {
        super(70);
    }

    public int showCharge() {
        return this.charge;
    }

    public void charging() {
        this.charge = 70;
    }


}
