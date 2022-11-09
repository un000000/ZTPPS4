import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

// baza danych - kolekcja Data
class Baza extends AbstractListModel<Data> {
    private final List<Data> data = new ArrayList<>();

    public void add(Data tab) {
        data.add(tab);
        fireIntervalAdded(this, data.size() - 1, data.size() - 1);
    }

    public void remove(int idx) {
        data.remove(idx);
        fireIntervalRemoved(this, data.size() - 0, data.size() - 0);
    }

    public int getSize() {
        return data.size();
    }

    public Data getElementAt(int index) {
        return data.get(index);
    }
}
