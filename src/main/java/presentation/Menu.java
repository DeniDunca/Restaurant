package presentation;

import business.DeliveryService;
import business.MenuItem;
import data.Serializer;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;

public class Menu extends JPanel {
    private JTable tb_table;
    DeliveryService r = new DeliveryService();
    Serializer serializer = new Serializer();

    public Menu() {

        this.tb_table = new JTable(new TableModel());
        this.tb_table.setPreferredScrollableViewportSize(new Dimension(500,500));
        this.tb_table.setFillsViewportHeight(true);
        JScrollPane sc_scroll = new JScrollPane(tb_table);
        add(sc_scroll, BorderLayout.CENTER);
        TableModel model = new TableModel();
        this.tb_table.setModel(model);
    }

    class TableModel extends AbstractTableModel
    {
        private final String[] headers = {"Title","Rating","Calories","Protein","Fat","Sodium","Price"};
        private ArrayList<MenuItem> data = new ArrayList<MenuItem>();

        public void addData(ArrayList<MenuItem> data)
        {
            this.data = data;
            this.fireTableDataChanged();
        }
        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return headers.length;
        }

        @Override
        public String getColumnName(int col) {
            return headers[col];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            MenuItem m = data.get(rowIndex);
            if(columnIndex == 0)
                return m.getTitle();
            if(columnIndex == 1)
                return m.getRating();
            if(columnIndex == 2)
                return m.getCalories();
            if(columnIndex == 3)
                return m.getProteins();
            if(columnIndex == 4)
                return m.getFats();
            if(columnIndex == 5)
                return m.getSodium();
            if(columnIndex == 6)
                return m.getPrice();
            return 0;
        }
    }

    JFrame frame = new JFrame("Menu");
    public void tableFrame()
    {
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 300);
        Menu menu = new Menu();
        frame.setContentPane(menu);
        frame.pack();
        frame.setVisible(true);
    }

    public void invisibleFrame()
    {
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 300);
        Menu menu = new Menu();
        frame.setContentPane(menu);
        frame.pack();
        frame.setVisible(false);
    }

    public void clientFrame()
    {
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 300);
        Menu menu = new Menu();
        ArrayList<MenuItem> rsw = r.getMenuItems();
        //rsw.forEach(System.out::println);
        TableModel model = new TableModel();
        menu.tb_table.setModel(model);
        model.addData(rsw);
        frame.setContentPane(menu);
        frame.pack();
        frame.setVisible(true);
    }
    public void importFrame()
    {
        r.importProducts("products.csv");
    }

    public DeliveryService getR() {

        return r;
    }

    public void serialize(){

        serializer.serialize(r);
    }
    public void deserialize()
    {
        r = serializer.deserialize("delivery.ser");
    }
}
