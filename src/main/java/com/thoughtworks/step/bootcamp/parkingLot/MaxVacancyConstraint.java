package com.thoughtworks.step.bootcamp.parkingLot;

import java.util.ArrayList;

public class MaxVacancyConstraint implements LotSelector {
    @Override
    public ParkingLot getAvailableLot(ArrayList<ParkingLot> parkingLots) {
        parkingLots.sort(ParkingLot:: compareAvailability);
        return parkingLots.get(0);
    }
}
