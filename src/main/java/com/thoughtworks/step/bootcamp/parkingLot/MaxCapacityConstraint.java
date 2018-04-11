package com.thoughtworks.step.bootcamp.parkingLot;

import java.util.ArrayList;

class MaxCapacityConstraint implements LotSelector {
    @Override
    public ParkingLot getAvailableLot(ArrayList<ParkingLot> parkingLots) {
        parkingLots.sort(ParkingLot::compareCapacity);
        return parkingLots.get(0);
    }
}
