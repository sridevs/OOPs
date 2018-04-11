package com.thoughtworks.step.bootcamp.parkingLot;

import java.util.ArrayList;

public class LotFilterByMaxVacancy implements Filterable {
    @Override
    public ParkingLot getAvailableLot(ArrayList<ParkingLot> parkingLots) {
        parkingLots.sort(ParkingLot:: compareAvailability);
        return parkingLots.get(0);
    }
}
