package com.thoughtworks.step.bootcamp.parking;


import java.util.ArrayList;

class Attendant {

    private ArrayList<ParkingLot> parkingLots;
    private int token = 0;

    Attendant() {
        this.parkingLots = new ArrayList<>();
    }

    public int park(int car) throws CantParkException {
        for (ParkingLot parkingLot : parkingLots) {
            if(!parkingLot.isLotFull()) {
                token++;
                return parkingLot.parkCar(token, car);
            }
        }
        throw new CantParkException("No space to park");
    }

    public void addLot(ParkingLot parkingLot) {
        this.parkingLots.add(parkingLot);
    }
}
