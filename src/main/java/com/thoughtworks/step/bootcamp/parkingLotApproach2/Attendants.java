package com.thoughtworks.step.bootcamp.parkingLotApproach2;

import java.io.IOException;
import java.util.ArrayList;

public class Attendants extends ArrayList<Attendant>{
    private ArrayList<Attendant> attendants;

    Attendants() {
        this.attendants = new ArrayList<>();
    }

    public void addAttendant(Attendant attendant) {
        attendants.add(attendant);
    }

    public void accept(HtmlReporter htmlReporter) throws IOException {
        for (Attendant attendant : attendants) {
            attendant.accept(htmlReporter);
        }
    }

    @Override
    public String toString() {
        StringBuilder reportBuilder = new StringBuilder("Attendants Report<br>");
        for (Attendant attendant : attendants) {
            reportBuilder.append(attendant.toString()).append("<br>");
        }
        System.out.println(reportBuilder);
        return reportBuilder.toString();
    }
}
