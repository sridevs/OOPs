package com.thoughtworks.step.bootcamp.parkingLot;

import java.util.HashMap;

class ParkingLot {
    private final int capacity;
    private  HashMap<Integer,Integer> vehicles;


    ParkingLot(int capacity) {
        this.capacity = capacity;
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

    public int compareCapacity(ParkingLot lot2) {
        if (this.capacity > lot2.capacity) {
            return -1;
        }else if (this.capacity < lot2.capacity){
            return 1;
        }
        return 0;
    }
    public int compareAvailability(ParkingLot lot2) {
        if (capacity - vehicles.size() > lot2.capacity - lot2.vehicles.size()){
            return -1;
        }else if (capacity - vehicles.size() < lot2.capacity - lot2.vehicles.size()){
            return 1;
        }
        return 0;
    }

    public boolean hasCarOfToken(int token) {
        return vehicles.containsKey(token);
    }
}
