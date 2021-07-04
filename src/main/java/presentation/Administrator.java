package presentation;

import business.BaseProduct;
import business.DeliveryService;
import data.Serializer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Administrator extends JFrame {

    private JButton b_add = new JButton("ADD");
    private JButton b_delete = new JButton("DELETE");
    private JButton b_modify = new JButton("MODIFY");
    private JButton b_exit = new JButton("EXIT");
    private JButton b_logout = new JButton("LOG OUT");
    private JButton b_import = new JButton("IMPORT");
    private JButton b_composite = new JButton("COMPOSITE");
    private JButton b_report1 = new JButton("REPORT 1");
    private JButton b_report2 = new JButton("REPORT 2");
    private JButton b_report3 = new JButton("REPORT 3");
    private JButton b_report4 = new JButton("REPORT 4");
    private JButton b_serialize = new JButton("SAVE");
    private JButton b_deserialize = new JButton("LOAD");

    private JTextField tf_title =new JTextField(13);
    private JTextField tf_price =new JTextField(13);
    private JTextField tf_rating =new JTextField(13);
    private JTextField tf_calories =new JTextField(13);
    private JTextField tf_protein =new JTextField(13);
    private JTextField tf_fat =new JTextField(13);
    private JTextField tf_sodium =new JTextField(13);
    private JTextField tf_timeStart =new JTextField(8);
    private JTextField tf_timeEnd =new JTextField(8);
    private JTextField tf_number =new JTextField(8);
    private JTextField tf_orderTimes =new JTextField(8);
    private JTextField tf_higherValue =new JTextField(8);
    private JTextField tf_specifiedDay =new JTextField(8);

    public void addExitListener(ActionListener exit)
    {
        b_exit.addActionListener(exit);
    }
    public void addAddListener(ActionListener add)
    {
        b_add.addActionListener(add);
    }
    public void addDeleteListener(ActionListener delete)
    {
        b_delete.addActionListener(delete);
    }
    public void addModifyListener(ActionListener modify)
    {
        b_modify.addActionListener(modify);
    }
    public void addLogOutListener(ActionListener logout)
    {
        b_logout.addActionListener(logout);
    }
    public void addImportListener(ActionListener imp)
    {
        b_import.addActionListener(imp);
    }
    public void addCompositeListener(ActionListener comp)
    {
        b_composite.addActionListener(comp);
    }
    public void add1Listener(ActionListener rep1)
    {
        b_report1.addActionListener(rep1);
    }
    public void add2Listener(ActionListener rep2)
    {
        b_report2.addActionListener(rep2);
    }
    public void add3Listener(ActionListener rep3)
    {
        b_report3.addActionListener(rep3);
    }
    public void add4Listener(ActionListener rep4)
    {
        b_report4.addActionListener(rep4);
    }
    public void addSerialize(ActionListener ser){b_serialize.addActionListener(ser);}
    public void addDeserialize(ActionListener ser){b_deserialize.addActionListener(ser);}

    Menu menu;
    public Administrator(Menu menu)
    {
        this.menu = menu;
        JPanel content0 = new JPanel();
        content0.setLayout(new FlowLayout());
        content0.setBackground(Color.decode("#5d86ec"));
        content0.add(new JLabel("Welcome, Administrator!"));

        JPanel content1 = new JPanel();
        content1.setLayout(new FlowLayout());
        content1.setBackground(Color.decode("#5d86ec"));
        content1.add(new JLabel("Title: "));
        content1.add(tf_title);
        content1.add(new JLabel("Rating: "));
        content1.add(tf_rating);

        JPanel content2 = new JPanel();
        content2.setLayout(new FlowLayout());
        content2.setBackground(Color.decode("#5d86ec"));
        content2.add(new JLabel("Price: "));
        content2.add(tf_price);
        content2.add(new JLabel("Calories: "));
        content2.add(tf_calories);

        JPanel content3 = new JPanel();
        content3.setLayout(new FlowLayout());
        content3.setBackground(Color.decode("#5d86ec"));
        content3.add(new JLabel("Protein: "));
        content3.add(tf_protein);
        content3.add(new JLabel("Fat: "));
        content3.add(tf_fat);
        content3.add(new JLabel("Sodium: "));
        content3.add(tf_sodium);

        JPanel content4 = new JPanel();
        content4.setLayout(new FlowLayout());
        content4.setBackground(Color.decode("#5d86ec"));
        content4.add(b_import);
        content4.add(b_add);
        content4.add(b_delete);
        content4.add(b_modify);
        content4.add(b_composite);

        JPanel content5 = new JPanel();
        content5.setLayout(new FlowLayout());
        content5.setBackground(Color.decode("#5d86ec"));
        content5.add(new JLabel("Orders placed in the time interval:"));
        content5.add(tf_timeStart);
        content5.add(tf_timeEnd);
        content5.add(b_report1);

        JPanel content6 = new JPanel();
        content6.setLayout(new FlowLayout());
        content6.setBackground(Color.decode("#5d86ec"));
        content6.add(new JLabel("Products ordered more than a number of times:"));
        content6.add(tf_number);
        content6.add(b_report2);

        JPanel content7 = new JPanel();
        content7.setLayout(new FlowLayout());
        content7.setBackground(Color.decode("#5d86ec"));
        content7.add(new JLabel("Clients that ordered more than a number of times and the order was higher than a value:"));
        content7.add(tf_orderTimes);
        content7.add(tf_higherValue);
        content7.add(b_report3);

        JPanel content8 = new JPanel();
        content8.setLayout(new FlowLayout());
        content8.setBackground(Color.decode("#5d86ec"));
        content8.add(new JLabel("Orders within a specified day:"));
        content8.add(tf_specifiedDay);
        content8.add(b_report4);

        JPanel content9 = new JPanel();
        content9.setLayout(new FlowLayout());
        content9.setBackground(Color.decode("#5d86ec"));
        content9.add(b_serialize);
        content9.add(b_deserialize);

        JPanel content10 = new JPanel();
        content10.setLayout(new FlowLayout());
        content10.setBackground(Color.decode("#5d86ec"));
        content10.add(b_logout);
        content10.add(b_exit);

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.add(content0);
        content.add(content1);
        content.add(content2);
        content.add(content3);
        content.add(content4);
        content.add(content5);
        content.add(content6);
        content.add(content7);
        content.add(content8);
        content.add(content9);
        content.add(content10);

        this.setContentPane(content);
        this.pack();
        this.setTitle("Administrator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 450);
    }

    public String getTf_title() {
        return tf_title.getText() + " ";
    }
    public double getTf_rating() {return Double.parseDouble(tf_rating.getText());}
    public int getTf_calories() {return Integer.parseInt(tf_calories.getText());}
    public int getTf_protein() {return Integer.parseInt(tf_protein.getText());}
    public int getTf_fats() {return Integer.parseInt(tf_fat.getText());}
    public int getTf_sodium() {return Integer.parseInt(tf_sodium.getText());}
    public int getTf_price() {return Integer.parseInt(tf_price.getText());}

    public void add()
    {
        DeliveryService service = menu.getR();
        service.addMenuItem(new BaseProduct(getTf_title(),getTf_rating(),getTf_calories(),getTf_protein(),getTf_fats(),getTf_sodium(),getTf_price()));
    }

    public void delete(){
        menu.r.deleteMenuItem(getTf_title());
    }

    public void edit() throws Exception {

        String title = getTf_title();
        double rating;
        int calories, fats, sodium, price, protein;
        String x = tf_rating.getText();
        if(x.equals(""))
        {
            rating = -1;
        }
        else
        {
            rating = getTf_rating();
        }
        x = tf_calories.getText();
        if(x.equals(""))
        {
            calories = -1;
        }
        else
        {
            calories = getTf_calories();
        }
        x = tf_fat.getText();
        if(x.equals(""))
        {
            fats = -1;
        }
        else
        {
            fats = getTf_fats();
        }
        x = tf_sodium.getText();
        if(x.equals(""))
        {
            sodium = -1;
        }
        else
        {
            sodium = getTf_sodium();
        }
        x = tf_price.getText();
        if(x.equals(""))
        {
            price = -1;
        }
        else
        {
            price = getTf_price();
        }
        x= tf_protein.getText();
        if(x.equals(""))
        {
            protein = -1;
        }
        else
        {
            protein = getTf_protein();
        }
        System.out.println(x);
        DeliveryService service = menu.getR();
        service.editMenuItem(new BaseProduct(title,rating,calories,protein,fats,sodium,price));
    }

    public void report1()
    {
        DeliveryService service = menu.getR();
        service.report1(Integer.parseInt(tf_timeStart.getText()), Integer.parseInt(tf_timeEnd.getText()));
    }

    public void report2()
    {
        DeliveryService service = menu.getR();
        service.report2(Integer.parseInt(tf_number.getText()));
    }

    public void report3()
    {
        DeliveryService service = menu.getR();
        service.report3(Integer.parseInt(tf_orderTimes.getText()),Integer.parseInt(tf_higherValue.getText()));
    }

    public void report4()
    {
        DeliveryService service = menu.getR();
        service.report4(Integer.parseInt(tf_specifiedDay.getText()));
    }

    public void serialize()
    {
        menu.serialize();
    }
    public void deserialize()
    {
        menu.deserialize();
    }

}