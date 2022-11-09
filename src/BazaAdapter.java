import javax.swing.table.AbstractTableModel;

class BazaAdapter extends AbstractTableModel {

    private Data data;

    public BazaAdapter() {
    }

    public void updateData(Data data) {
        this.data = data;
        fireTableStructureChanged();
    }

    @Override
    public int getRowCount() {
        if (data == null) {
            return 0;
        }
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return rowIndex;
        }
        return data.get(rowIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex != 0;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        data.set(rowIndex, (int) aValue);
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Integer.class;
    }
}
