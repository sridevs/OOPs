package com.thoughtworks.step.bootcamp.parkingLotApproach2;

import java.io.IOException;

interface Reporter {
    String generateReport(Attendant attendant) throws IOException;
}
