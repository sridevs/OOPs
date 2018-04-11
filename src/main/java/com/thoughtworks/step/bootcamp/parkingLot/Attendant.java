package com.thoughtworks.step.bootcamp.parkingLot;

class Attendant {

    private final ParkingLots parkingLots;
    private ParkingLots fullyOccupiedParkingLots;
    private int token = 0;

    Attendant(Filterable lotFilter) {
        this.parkingLots = new ParkingLots(lotFilter);
        this.fullyOccupiedParkingLots = new ParkingLots(lotFilter);
    }


    public void addLot(ParkingLot parkingLot) {
        this.parkingLots.add(parkingLot);
    }

    public int park(int car) throws CantParkException {
        token++;
        ParkingLot firstParkingLot = parkingLots.availableLot();
        firstParkingLot.park(token, car);
        if (parkingLots.firstLot().isLotFull()) {
            fullyOccupiedParkingLots.add(parkingLots.firstLot());
            parkingLots.removeFirstLot();
        }
        return token;
    }
}
