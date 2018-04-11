package com.thoughtworks.step.bootcamp.parkingLot;

import java.util.ArrayList;

class LotFilterByMaxCapacity implements Filterable{
    @Override
    public ParkingLot getAvailableLot(ArrayList<ParkingLot> parkingLots) {
        parkingLots.sort(ParkingLot::compareCapacity);
        return parkingLots.get(0);
    }
}
