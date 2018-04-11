package com.thoughtworks.step.bootcamp.parkingLot;

import java.util.ArrayList;

class ParkingLots {
    private final LotSelector lotSelector;
    private ArrayList<ParkingLot> parkingLots;

    ParkingLots(LotSelector lotFilter) {
        this.parkingLots = new ArrayList<>();
        this.lotSelector = lotFilter;
    }

    public ParkingLot firstLot(){
        return parkingLots.get(0);
    }

    public void add(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }

    public void removeFirstLot() {
        parkingLots.remove(0);
    }

    public ParkingLot availableLot() throws CantParkException {
        if (parkingLots.isEmpty()) throw new CantParkException("No available lots");
        return lotSelector.getAvailableLot(parkingLots);
    }
}