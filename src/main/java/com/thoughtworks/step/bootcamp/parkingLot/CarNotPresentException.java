package com.thoughtworks.step.bootcamp.parkingLot;

class CarNotPresentException extends Throwable {
    CarNotPresentException() {
        super("There's no such car");
    }
}
