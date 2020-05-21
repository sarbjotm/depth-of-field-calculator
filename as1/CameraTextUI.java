import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Sample (incomplete) text UI to interact with the user.
 * You may change any part of this!
 */
public class CameraTextUI {
    private static final double COC = 0.029;    // "Circle of Confusion" for a "Full Frame" camera
    private LensManager manager;
    private Scanner in = new Scanner(System.in);// Read from keyboard


    public CameraTextUI(LensManager manager) {
        // Accept and store a reference to the lens manager (the model)
        // (this design is called "dependency injection")
        this.manager = manager;

        // Populate lenses (Make, max aperture (smallest supported F number), focal length [mm]):
        manager.add(new Lens("Canon", 1.8, 50));
        manager.add(new Lens("Tamron", 2.8, 90));
        manager.add(new Lens("Sigma", 2.8, 200));
        manager.add(new Lens("Nikon", 4, 200));
    }

    public void show() {
        // BEGIN SAMPLE USING SCREEN AND KEYBOARD:
        // (remove this: it's just to show you how to access the screen and keyboard!)
        System.out.println("Enter an integer: ");
        System.out.print(": ");
        int count = in.nextInt();

        System.out.println("Enter an double: ");
        System.out.print(": ");
        double value = in.nextDouble();

        System.out.println("Printing " + value + " out " + count + " times (with formatting)!");
        for (int i = 0; i < count; i++) {
            System.out.println(" --> " + formatM(value));
        }

        // END SAMPLE
    }

    private String formatM(double distanceInM) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(distanceInM);
    }
}
