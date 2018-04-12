package com.thoughtworks.step.bootcamp.parkingLotApproach2;

import java.util.HashMap;


class ParkingLot {
    private final int capacity;
    private final int id;
    private  HashMap<Integer,Integer> vehicles;
    private static int ID = 0;

    ParkingLot(int capacity) {
        this.capacity = capacity;
        this.id = ++ID;
        this.vehicles = new HashMap<>();
    }

    public int park(int token, int car) throws CantParkException {
        validateParking(car);
        vehicles.put(token,car);
        return token;
    }

    private void validateParking(int car) throws CantParkException {
        if (vehicles.containsValue(car)) throw new CantParkException("Double entry not allowed");
        if(isLotFull()) throw new CantParkException("Lot is full");
    }

    public int checkOut(int token) throws CarNotPresentException {
        validateCheckout(token);
        return vehicles.remove(token);
    }

    private void validateCheckout(int token) throws CarNotPresentException {
        if(!vehicles.containsKey(token)) throw new CarNotPresentException();
    }

    public boolean isLotFull() {
        return vehicles.size() == capacity;
    }

    @Override
    public String toString() {
        return "ParkingLot" +
                "Id =" + id +
                "   capacity=" + capacity;
    }
}
