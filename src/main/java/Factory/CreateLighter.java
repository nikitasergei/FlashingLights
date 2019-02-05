package Factory;

import Factory.Lighters.Lighter;

public interface CreateLighter {

    Lighter lighter(char batteryType, char lampType);

}
