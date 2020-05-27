package Model;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class depthofFieldCalculatorTest {

    /*
    NOTE: delta of 0.09 as the formatM function is in the UI class and not depthofField
    Also dividing by 1000 to calculate in m
     */

    @org.junit.jupiter.api.Test
    void calculateHyperFocalLength() {
        depthofFieldCalculator d = new depthofFieldCalculator();
        assertEquals(47.89, d.calculateHyperFocalLength(50,1.8)/1000,0.01);
        assertEquals(8.62,d.calculateHyperFocalLength(50,10)/1000,0.01);
        assertEquals(76.63,d.calculateHyperFocalLength(2,1.8),0.01);

    }

    @org.junit.jupiter.api.Test
    void calculateNearPoint() {
        depthofFieldCalculator d = new depthofFieldCalculator();
        assertEquals(1.08, d.calculateNearPoint(47.89*1000,1.1*1000,50)/1000,0.01);
        assertEquals(3.17, d.calculateNearPoint(8.62*1000,5*1000,50)/1000,0.01);
        assertEquals(496.77,d.calculateNearPoint(76.63*1000,500,2),0.01);
    }

    @org.junit.jupiter.api.Test
    void calculateFarPoint() {
        depthofFieldCalculator d = new depthofFieldCalculator();
        assertEquals(1.12, d.calculateFarPoint(47.89*1000,1.1*1000,50)/1000,0.01);
        assertEquals(11.74, d.calculateFarPoint(8620,5000,50)/1000,0.01);
        assertEquals(503.27,d.calculateFarPoint(76.63*1000,500,2),0.01);
    }

    @org.junit.jupiter.api.Test
    void depthOfField() {
        depthofFieldCalculator d = new depthofFieldCalculator();
        assertEquals(0.05, d.depthOfField(1.08,1.12),0.01);
        assertEquals(8.57, d.depthOfField(3.17,11.74),0.01);
        assertEquals(6.5, d.depthOfField(496.77,503.27),0.01);

    }
}