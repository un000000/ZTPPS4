import java.util.AbstractList;
import java.util.ArrayList;

class DataProxy implements Data {

    private Data data;
    private final int size;

    public DataProxy(int size) {
        this.size = size;
    }

    @Override
    public int get(int idx) {
        if(data == null) {
            return 0;
        }
        return data.get(idx);
    }

    @Override
    public void set(int idx, int value) {
        if(data == null) {
            data = new RealData(size);
        }
        data.set(idx, value);
    }

    @Override
    public int size() {
        return size;
    }
}
