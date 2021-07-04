package presentation;

import business.DeliveryService;
import business.Observer;
import business.Order;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Employee extends JFrame implements Observer{

    private JButton b_exit = new JButton("EXIT");
    private JButton b_logout = new JButton("LOG OUT");

    private JTextArea ta_orders = new JTextArea(40, 40);

    public void addExitListener(ActionListener exit)
    {
        b_exit.addActionListener(exit);
    }
    public void addLogOutListener(ActionListener logout) {b_logout.addActionListener(logout); }

    Menu menu;

    public Employee(Menu menu)
    {
        this.menu = menu;
        JPanel content0 = new JPanel();
        content0.setLayout(new FlowLayout());
        content0.setBackground(Color.decode("#5d86ec"));
        content0.add(new JLabel("Welcome, Employee!"));

        JPanel content1 = new JPanel();
        content1.setLayout(new FlowLayout());
        content1.setBackground(Color.decode("#5d86ec"));
        content1.add(new JLabel("You have an order: "));


        JPanel content2 = new JPanel();
        content2.setLayout(new FlowLayout());
        content2.setBackground(Color.decode("#5d86ec"));
        content2.add(ta_orders);

        JPanel content3 = new JPanel();
        content3.setLayout(new FlowLayout());
        content3.setBackground(Color.decode("#5d86ec"));
        content3.add(b_logout);
        content3.add(b_exit);

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.add(content0);
        content.add(content1);
        content.add(content2);
        content.add(content3);

        this.setContentPane(content);
        this.pack();
        this.setTitle("Employee");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);

    }

    public void populate()
    {
        ta_orders.setText("");
        DeliveryService service = menu.getR();
        ArrayList<Order> o = service.getOrders();
        for(Order order : o)
        {
            ta_orders.append("Order nr:" + order.getId() + "| From client: " + order.getName() + "| date: " + order.getDate());
            ta_orders.append("\n");
            ta_orders.append("Has ordered: " + service.getOrderedProductsName(order) + " Price: " + service.computePrice(order));
            ta_orders.append("\n");
        }
    }

    public void update(){
        populate();
    }
}
