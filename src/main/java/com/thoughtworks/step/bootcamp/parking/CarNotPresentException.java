package com.thoughtworks.step.bootcamp.parking;

class CarNotPresentException extends Throwable {
    public CarNotPresentException() {
        super("There's no such car");
    }
}
