package com.thoughtworks.step.bootcamp.parking;

import java.util.HashMap;

class ParkingLot {
    private final int capacity;
    private  HashMap<Integer,Integer> vehicles;
    private Listeners listeners;

    ParkingLot(int capacity, Listeners listeners) {
        this.capacity = capacity;
        this.vehicles = new HashMap<>();
        this.listeners = listeners;
    }

    ParkingLot(int capacity) {
        this.capacity = capacity;
        this.vehicles = new HashMap<>();
        this.listeners = new Listeners();
    }

    public int parkCar(int token,int car) throws CantParkException {
        validateParking(car);
        vehicles.put(token,car);
        if(isLotFull()) {
            listeners.sayNoSpace();
        }
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
}
