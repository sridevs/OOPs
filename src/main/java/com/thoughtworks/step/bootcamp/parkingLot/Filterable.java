package com.thoughtworks.step.bootcamp.parkingLot;

import java.util.ArrayList;

public interface Filterable {
    ParkingLot getAvailableLot(ArrayList<ParkingLot> parkingLots);
}
