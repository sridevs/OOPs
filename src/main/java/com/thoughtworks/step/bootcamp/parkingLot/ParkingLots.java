package com.thoughtworks.step.bootcamp.parkingLot;

import java.util.ArrayList;

class ParkingLots {
    private final Filterable availableLotFilter;
    private ArrayList<ParkingLot> parkingLots;

    ParkingLots(Filterable lotFilter) {
        this.parkingLots = new ArrayList<>();
        this.availableLotFilter = lotFilter;
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
        return availableLotFilter.getAvailableLot(parkingLots);
    }
}