// prosta implementacja danych - tablica
class RealData implements Data {
    private int[] data;

    public RealData(int size) {
        this.data = new int[size];
    }

    public int get(int idx) {
        return data[idx];
    }

    public void set(int idx, int value) {
        data[idx] = value;
    }

    public int size() {
        return data.length;
    }

}