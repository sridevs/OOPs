package com.thoughtworks.step.bootcamp.parkingLot;

import java.util.ArrayList;

public class LotFilter implements Filterable {
    @Override
    public ParkingLot getAvailableLot(ArrayList<ParkingLot> parkingLots) {
        return parkingLots.get(0);
    }
}
