package presentation;

import business.DeliveryService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Composite extends JFrame {

    private JTextField tf_productName = new JTextField(15);
    private JTextField tf_menuName = new JTextField(15);
    private JTextArea ta_menu = new JTextArea(50,50);

    private JButton b_addProduct = new JButton("ADD PRODUCT");
    private JButton b_save = new JButton("SAVE");

    public void addAddCListener(ActionListener add)
    {
        b_addProduct.addActionListener(add);
    }
    public void addSaveListener(ActionListener save)
    {
        b_save.addActionListener(save);
    }

    Administrator admin;
    Menu menu;
    public Composite(Administrator admin, Menu menu)
    {
        this.admin = admin;
        this.menu = menu;
        JPanel content0 = new JPanel();
        content0.setLayout(new FlowLayout());
        content0.setBackground(Color.decode("#5d86ec"));
        content0.add(new JLabel("Composite Products"));

        JPanel content1 = new JPanel();
        content1.setLayout(new FlowLayout());
        content1.setBackground(Color.decode("#5d86ec"));
        content1.add(new JLabel("Product name:"));
        content1.add(tf_productName);
        content1.add(new JLabel("Menu name:"));
        content1.add(tf_menuName);

        JPanel content2 = new JPanel();
        content2.setLayout(new FlowLayout());
        content2.setBackground(Color.decode("#5d86ec"));
        content2.add(b_addProduct);

        JPanel content3 = new JPanel();
        content3.setLayout(new FlowLayout());
        content3.setBackground(Color.decode("#5d86ec"));
        content3.add(ta_menu);

        JPanel content4 = new JPanel();
        content4.setLayout(new FlowLayout());
        content4.setBackground(Color.decode("#5d86ec"));
        content4.add(b_save);

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.add(content0);
        content.add(content1);
        content.add(content2);
        content.add(content3);
        content.add(content4);

        this.setContentPane(content);
        this.pack();
        this.setTitle("Composite product");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 300);
    }

    public String getTf_product()
    {
        return tf_productName.getText();
    }
    public String getTf_menuName()
    {
        return tf_menuName.getText();
    }

    public void addProd()
    {
        String prod = getTf_product();
        ta_menu.append(prod + "\n");
        DeliveryService service = menu.getR();
        service.temporaryComposite(prod);
    }

    public void save()
    {
        DeliveryService service = menu.getR();
        service.saveComposite(getTf_menuName());
    }

}
