package Model;
import java.lang.Math;


public class depthofFieldCalculator {
  /*
        A lens - focal length and mximum aperture
        distance to subject
        aperture to use for the photo
        Circle of confusion - 0.029mm
   */

    private double hyperFocalDistance;
    private double nearFocalPoint;
    private double farFocalPoint;
    private double depthOfField;
    private double circleofConfusion = 0.029;

    public double hyperFocalDistanceCalculator(double aperture){

        double hyperFocalDistance = Math.pow(aperture * circleofConfusion,2);
        return hyperFocalDistance;
    }

}

