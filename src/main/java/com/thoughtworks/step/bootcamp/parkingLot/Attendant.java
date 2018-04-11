package com.thoughtworks.step.bootcamp.parkingLot;

class Attendant {

    private final ParkingLots availableParkingLots;
    private ParkingLots fullyOccupiedParkingLots;
    private int token = 0;

    Attendant(LotSelector lotFilter) {
        this.availableParkingLots = new ParkingLots(lotFilter);
        this.fullyOccupiedParkingLots = new ParkingLots(lotFilter);
    }


    public void addLot(ParkingLot parkingLot) {
        this.availableParkingLots.add(parkingLot);
    }

    public int park(int car) throws CantParkException {
        token++;
        ParkingLot firstParkingLot = availableParkingLots.availableLot();
        firstParkingLot.park(token, car);
        if (availableParkingLots.firstLot().isLotFull()) {
            fullyOccupiedParkingLots.add(availableParkingLots.firstLot());
            availableParkingLots.removeFirstLot();
        }
        return token;
    }
}
