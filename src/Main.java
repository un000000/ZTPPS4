import jdk.jshell.spi.ExecutionControl;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


class ztp4 {

    public static void main(String[] args) {

        //Logger logger = Logger.getLogger(ztp4.class.getName());
        //logger.setLevel(Level.INFO);

        final Baza dane = new Baza();

        final JFrame frame = new JFrame("Zadanie 4");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JSplitPane splitPane = new JSplitPane();

        final JList<Data> list = new JList<>(dane);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBorder(BorderFactory.createTitledBorder(" Tablice: "));
        splitPane.setLeftComponent(scrollPane);

        BazaAdapter bazaAdapter = new BazaAdapter();
        JTable table = new JTable(bazaAdapter);
        scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createTitledBorder(" Zawartość: "));
        splitPane.setRightComponent(scrollPane);

        frame.getContentPane().add(splitPane);

        JMenuBar bar = new JMenuBar();
        JButton add = new JButton("Dodaj tablicę");
        JButton del = new JButton("Usuń tablicę");
        bar.add(add);
        bar.add(del);

        frame.setJMenuBar(bar);

        frame.setSize(600, 450);
        frame.setVisible(true);

        splitPane.setDividerLocation(0.5);

        add.addActionListener(e -> {
            String value = JOptionPane.showInputDialog(frame,
                    "Podaj rozmiar tablicy",
                    "Dodaj",
                    JOptionPane.INFORMATION_MESSAGE);
            try {
                int size = Integer.parseInt(value);
                dane.add(new DataProxy(size));
            } catch (ClassCastException ex) {
                JOptionPane.showMessageDialog(frame,
                        "Fajny ten rozmiar, taki nie za poprawny.",
                        "Error",
                        JOptionPane.INFORMATION_MESSAGE);
                Logger LOGGER = Logger.getLogger("logger123");
                LOGGER.log(Level.INFO, "", ex.getMessage());
            }
        });
        del.addActionListener(e -> {
            int idx = list.getSelectedIndex();
            try {
                dane.remove(idx);
            } catch (ClassCastException ex) {
                JOptionPane.showMessageDialog(frame,
                        "Exception caught on table delete.",
                        "Error",
                        JOptionPane.INFORMATION_MESSAGE);
                Logger LOGGER = Logger.getLogger("logger123");
                LOGGER.log(Level.INFO, "", ex.getMessage());
            }
        });

        // zmiana wyboru na liście powoduje odświeżenie tabeli
        list.addListSelectionListener(e -> {
            int idx = list.getSelectedIndex();
            if (idx >= 0) {
                Data selectedValue = list.getModel().getElementAt(e.getFirstIndex());
                //Data selectedValue = list.getSelectedValue();
                bazaAdapter.updateData(selectedValue);
            }
            });
    }
}