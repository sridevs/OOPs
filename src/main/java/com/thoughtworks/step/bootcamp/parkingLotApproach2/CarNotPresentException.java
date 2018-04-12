package com.thoughtworks.step.bootcamp.parkingLotApproach2;

class CarNotPresentException extends Throwable {
    public CarNotPresentException() {
        super("There's no such car");
    }
}
