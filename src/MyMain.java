import Model.Lens;
import Model.lensManager;
import TextUi.textUi;

import java.util.ArrayList;

public class MyMain {
    public static void main(String args[]) {

        lensManager manager = new lensManager();
        textUi ui = new textUi(manager);
        manager.add(new Lens("Canon", 50, 1.8));
        manager.add(new Lens("Tamron", 90, 2.8));
        manager.add(new Lens("Sigma", 200, 2.8));
        manager.add(new Lens("Nikon", 200, 4.0));

        ui.show();
    }
}

