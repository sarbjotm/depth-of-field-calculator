package TextUi;

import Model.Lens;
import Model.depthofFieldCalculator;
import Model.lensManager;

import java.text.DecimalFormat;
import java.util.Scanner;


public class textUi {
    private Scanner userInput = new Scanner(System.in);
    private Scanner userInput2 = new Scanner(System.in);
    private Scanner userInput3 = new Scanner(System.in);
    private lensManager manager;
    private int number;
    private int i = 0;
    private boolean isDone;
    private double aperture;
    private double focalLength;
    private double hyperFocalLength;
    private double nearFocalLength;
    private double farFocalLength;
    private double userAperture;
    private double depthOfField;
    private double distance;

    private String formatM(double distanceInM) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(distanceInM);
    }

    private double convertToMeters(double millimeters){
        return millimeters/1000;
    }

    public textUi(lensManager manager) {

        this.manager = manager;
        manager.add(new Lens("Canon", 50, 1.8));
        manager.add(new Lens("Tamron", 90, 2.8));
        manager.add(new Lens("Sigma", 200, 2.8));
        manager.add(new Lens("Nikon", 200, 4.0));
    }

    depthofFieldCalculator calculator = new depthofFieldCalculator();

    public void show(){
        isDone = false;
        /*
        To ask user what lens they need, and checking if an invalid index was entered or if a int was not entered
         */
        while (!isDone){
            do{
                i = 0;
                System.out.println("Lenses to pick from: ");
                for (Lens l : manager){
                    System.out.println("\t" + i + ". " + l.getMake() + " " + l.getFocalLength() +"mm F" + l.getMaximumAperture());
                    i = i + 1;
                }

                System.out.println("\t(-1 to exit)");
                System.out.printf(": ");
                while(!userInput.hasNextInt()){
                    i = 0;
                    System.out.println("ERROR: Invalid lens index.");
                    System.out.println("Lenses to pick from:");
                    for (Lens l : manager){
                        System.out.println("\t" + i + ". " + l.getMake() + " " + l.getMaximumAperture() +"mm F" + l.getFocalLength());
                        i = i + 1;
                    }
                    System.out.println("\t(-1 to exit)");
                    System.out.printf(": ");
                    userInput.next();
                }
                number = userInput.nextInt();
                if(number >= 4 || number <= -2){
                    System.out.println("ERROR: Invalid lens index. \n");
                }
            }while(number >= 4 || number <= -2);
            if (number == -1){
                isDone = false;
                break;
            }
            focalLength = manager.getFocalLength(number);
            aperture = manager.getAperture(number);
            showAperture();
        }
    }
        public void showAperture(){
            System.out.printf("Aperture [the F number]: ");

            userAperture = userInput2.nextDouble();
            if (userAperture < aperture){
                System.out.printf("ERROR: This aperture is not possible with this lens\n\n");
                show();
            }

            System.out.printf("Distance to subject [m]: ");
            distance = userInput3.nextDouble();
            distance = distance * 1000; //Converting to mm

            hyperFocalLength = calculator.calculateHyperFocalLength(focalLength,userAperture);
            nearFocalLength = calculator.calculateNearPoint(hyperFocalLength,distance,focalLength);
            if(distance > hyperFocalLength){
                farFocalLength = Double.POSITIVE_INFINITY;
            }
            else{
                farFocalLength = calculator.calculateFarPoint(hyperFocalLength,distance,focalLength);
            }

            depthOfField = calculator.depthOfField(nearFocalLength,farFocalLength);
            hyperFocalLength = convertToMeters(hyperFocalLength);
            nearFocalLength = convertToMeters(nearFocalLength);
            farFocalLength = convertToMeters(farFocalLength);
            depthOfField = convertToMeters(depthOfField);

            System.out.println("\t In focus: " + formatM(nearFocalLength) + "m to " + formatM(farFocalLength) +"m [DoF = " + formatM(depthOfField) +"m]");
            System.out.println("\t Hyperfocal point: " + formatM(hyperFocalLength) + "m");
            System.out.println();



    }




}


