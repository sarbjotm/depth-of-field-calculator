package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class lensManager implements Iterable<> {
    private List<Lens> lenses = new ArrayList<>();

    public void add(Lens lens){
        lenses.add(lens);
    }

    @Override
    public Iterator iterator() {
        return lenses.iterator();
    }
}
