package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class lensManager implements Iterable<Lens>{
    private List<Lens> lenses = new ArrayList<>();

    public void add(Lens lens){
        lenses.add(lens);

    }

    public double getFocalLength(int n) {
        return lenses.get(n).getFocalLength();
    }

    public double getAperture(int n) {
        return lenses.get(n).getMaximumAperture();
    }


    @Override
    public Iterator iterator() {
        return lenses.iterator();
    }

}
