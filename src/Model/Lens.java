package Model;

public class Lens {
    /*
        Store Model.Lens information here, such as make, maximum Aperture and the Focal Length
     */
    private String make;
    private double maximumAperture;
    private int focalLength;

    //Constructor
    public Lens(String make, double maximumAperture, int focalLength) {
        this.make = make;
        this.maximumAperture = maximumAperture;
        this.focalLength = focalLength;
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
    public int getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(int focalLength) {
        this.focalLength = focalLength;
    }

}
