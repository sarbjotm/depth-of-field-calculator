package TextUi;

import Model.Lens;
import Model.lensManager;

public class textUi {
    private lensManager manager;
    private int i = 0;

    public textUi(lensManager manager) {
        this.manager = manager;
    }

    public void show(){
        boolean isDone = false;
        while (!isDone){
            for (Lens l : manager){
                System.out.println( i + ". " + l.getMake() + " " + l.getMaximumAperture() +"mm F" + l.getFocalLength());
                i = i + 1;
            }
            isDone = true;
        }

    }
}


