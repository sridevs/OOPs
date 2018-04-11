package com.thoughtworks.step.bootcamp.parkingLot;

class CantParkException extends Throwable {
    CantParkException(String message) {
        super(message);
    }
}
