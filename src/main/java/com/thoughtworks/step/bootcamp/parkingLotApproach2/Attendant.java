package com.thoughtworks.step.bootcamp.parkingLotApproach2;


import java.io.IOException;
import java.util.ArrayList;

class Attendant {

    private ArrayList<ParkingLot> parkingLots;
    private int token = 0;
    private String name;

    Attendant(String name) {
        this.name = name;
        this.parkingLots = new ArrayList<>();
    }

    public int park(int car) throws CantParkException {
        for (ParkingLot parkingLot : parkingLots) {
            if(!parkingLot.isLotFull()) {
                token++;
                return parkingLot.park(token, car);
            }
        }
        throw new CantParkException("No space to park");
    }

    public void addLot(ParkingLot parkingLot) {
        this.parkingLots.add(parkingLot);
    }

    @Override
    public String toString() {
        StringBuilder reportBuilder = new StringBuilder("Attendant name:" + name + "<br>");
        for (ParkingLot parkingLot : parkingLots) {
            reportBuilder.append(parkingLot.toString()).append("<br>");
        }
        System.out.println(reportBuilder);
        return reportBuilder.toString();
    }

    public String accept(Reporter mockHtmlReporter) throws IOException {
       return mockHtmlReporter.generateReport(this);
    }
}
