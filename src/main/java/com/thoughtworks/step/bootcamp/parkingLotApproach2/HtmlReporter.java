package com.thoughtworks.step.bootcamp.parkingLotApproach2;

import java.io.FileWriter;
import java.io.IOException;

class HtmlReporter implements Reporter{
    public String generateReport(Attendant attendant) throws IOException {
        final String report = "<h1>Attendant report:</h1>" +
                "<h2>"+ attendant.toString() + "</h2>";
        final FileWriter fileWriter = new FileWriter("report.html");
        fileWriter.write(report);
        fileWriter.close();
        return report;
    }
}
