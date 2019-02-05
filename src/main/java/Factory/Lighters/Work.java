package Factory.Lighters;

import Factory.Battery.Accumulator;

public interface Work {

    boolean turnOn();

    void turnOff();

    Accumulator getAccumulator();
}
