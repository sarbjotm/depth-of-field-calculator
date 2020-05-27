package Model;
public class depthofFieldCalculator {

    private double calculationTemp;
    private double circleOfConfusion = 0.029;

    public depthofFieldCalculator() {

    }
  /*
        A lens - focal length and mximum aperture
        distance to subject
        aperture to use for the photo
        Circle of confusion - 0.029mm
   */

    public double calculateHyperFocalLength(double lensFocal, double aperture){
        calculationTemp = ((lensFocal*lensFocal) / (aperture * circleOfConfusion));
        return calculationTemp;
    }

    public double calculateNearPoint(double hyperFocalLength, double distance, double lensFocal){
        calculationTemp = (hyperFocalLength * distance) / (hyperFocalLength + (distance - lensFocal));
        return calculationTemp;
    }

    public double calculateFarPoint(double hyperFocalLength, double distance, double lensFocal){
        calculationTemp = ((hyperFocalLength * distance) / (hyperFocalLength - (distance - lensFocal)));
        return calculationTemp;
    }

    public double depthOfField(double nearPoint, double farPoint){
        calculationTemp = farPoint - nearPoint;
        return calculationTemp;
    }







}

