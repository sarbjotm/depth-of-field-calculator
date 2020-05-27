package Model;

public class Lens {
    /*
        Store Model.Lens information here, such as make, maximum Aperture and the Focal Length
     */
    private String make;
    private double maximumAperture;
    private double focalLength;

    //Constructor
    public Lens(String make, double focalLength, double maximumAperture) {
        this.make = make;
        this.focalLength = focalLength;
        this.maximumAperture = maximumAperture;

    }


    //Getters and Setters for make
    public String getMake() {
        return make;

    }

    public void setMake(String make) {
        this.make = make;
    }

    //Getters and Setters for maximumAperture
    public double getMaximumAperture() {
        return maximumAperture;
    }

    public void setMaximumAperture(double maximumAperture) {
        this.maximumAperture = maximumAperture;
    }

    //Getters and Setters for focalLength
    public double getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(double focalLength) {
        this.focalLength = focalLength;
    }

}
