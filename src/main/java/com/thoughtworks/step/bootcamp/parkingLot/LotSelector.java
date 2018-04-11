package com.thoughtworks.step.bootcamp.parkingLot;

import java.util.ArrayList;

public interface LotSelector {
    ParkingLot getAvailableLot(ArrayList<ParkingLot> parkingLots);
}
