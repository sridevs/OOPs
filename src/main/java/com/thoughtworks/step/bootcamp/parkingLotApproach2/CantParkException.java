package com.thoughtworks.step.bootcamp.parkingLotApproach2;

class CantParkException extends Throwable {
    CantParkException(String message) {
        super("Cannot park the same car twice");
    }
}
