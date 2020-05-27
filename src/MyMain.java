import Model.lensManager;
import TextUi.textUi;

public class MyMain {
    public static void main(String args[]) {

        lensManager manager = new lensManager();
        textUi ui = new textUi(manager);
        ui.show();
    }
}

