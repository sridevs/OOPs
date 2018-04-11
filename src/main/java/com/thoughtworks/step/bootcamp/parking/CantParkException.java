package com.thoughtworks.step.bootcamp.parking;

class CantParkException extends Throwable {
    CantParkException(String message) {
        super("Cannot park the same car twice");
    }
}
