package presentation;

import business.DeliveryService;
import business.MenuItem;
import business.Observer;
import business.Subject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.*;
import java.util.ArrayList;

public class Client extends JFrame {

    private int idOrder = -1;

    private JButton b_order = new JButton("ORDER");
    private JButton b_search = new JButton("SEARCH");
    private JButton b_exit = new JButton("EXIT");
    private JButton b_logout = new JButton("LOG OUT");
    private JButton b_viewMenu = new JButton("MENU");
    private JButton b_addToCart = new JButton("ADD TO CART");

    private JTextField tf_searchIngredient =new JTextField(20);
    private JTextField tf_searchRating =new JTextField(20);
    private JTextField tf_searchCalories =new JTextField(20);
    private JTextField tf_searchProteins =new JTextField(20);
    private JTextField tf_searchFats =new JTextField(20);
    private JTextField tf_searchSodium =new JTextField(20);
    private JTextField tf_searchPrice =new JTextField(20);

    private JTextField tf_totalPrice =new JTextField(20);
    private JTextArea ta_cart =new JTextArea(50,50);

    private JComboBox cb_product = new JComboBox(getProductName());

    public void addExitListener(ActionListener exit)
    {
        b_exit.addActionListener(exit);
    }
    public void addOrderListener(ActionListener order)
    {
        b_order.addActionListener(order);
    }
    public void addLogOutListener(ActionListener logout){ b_logout.addActionListener(logout);}
    public void addSearchListener(ActionListener search){ b_search.addActionListener(search);}
    public void addViewMenuListener(ActionListener viewMenu){ b_viewMenu.addActionListener(viewMenu);}
    public void addToCartListener(ActionListener addToCart){ b_addToCart.addActionListener(addToCart);}

    Menu menu;
    LogIn login;
    Subject subject;

    public Client(Menu menu, LogIn login, Subject subject, Employee employee)
    {
        this.menu = menu;
        this.login = login;
        this.subject = subject;
        subject.addObserver(employee);

        JPanel content0 = new JPanel();
        content0.setLayout(new FlowLayout());
        content0.setBackground(Color.decode("#5d86ec"));
        content0.add(new JLabel("Welcome, Client!"));

        JPanel content1 = new JPanel();
        content1.setLayout(new FlowLayout());
        content1.setBackground(Color.decode("#5d86ec"));
        content1.add(b_viewMenu);

        JPanel content2 = new JPanel();
        content2.setLayout(new FlowLayout());
        content2.setBackground(Color.decode("#5d86ec"));
        content2.add(new JLabel("Search by ingredient: "));
        content2.add(tf_searchIngredient);

        JPanel content3 = new JPanel();
        content3.setLayout(new FlowLayout());
        content3.setBackground(Color.decode("#5d86ec"));
        content3.add(new JLabel("Search by rating:        "));
        content3.add(tf_searchRating);

        JPanel content4 = new JPanel();
        content4.setLayout(new FlowLayout());
        content4.setBackground(Color.decode("#5d86ec"));
        content4.add(new JLabel("Search by calories:     "));
        content4.add(tf_searchCalories);

        JPanel content5 = new JPanel();
        content5.setLayout(new FlowLayout());
        content5.setBackground(Color.decode("#5d86ec"));
        content5.add(new JLabel("Search by proteins:    "));
        content5.add(tf_searchProteins);

        JPanel content6 = new JPanel();
        content6.setLayout(new FlowLayout());
        content6.setBackground(Color.decode("#5d86ec"));
        content6.add(new JLabel("Search by fats:            "));
        content6.add(tf_searchFats);

        JPanel content7 = new JPanel();
        content7.setLayout(new FlowLayout());
        content7.setBackground(Color.decode("#5d86ec"));
        content7.add(new JLabel("Search by sodium:     "));
        content7.add(tf_searchSodium);

        JPanel content8 = new JPanel();
        content8.setLayout(new FlowLayout());
        content8.setBackground(Color.decode("#5d86ec"));
        content8.add(new JLabel("Search by price:         "));
        content8.add(tf_searchPrice);

        JPanel content9 = new JPanel();
        content9.setLayout(new FlowLayout());
        content9.setBackground(Color.decode("#5d86ec"));
        content9.add(b_search);

        JPanel content10 = new JPanel();
        content10.setLayout(new FlowLayout());
        content10.setBackground(Color.decode("#5d86ec"));
        content10.add(cb_product);

        JPanel content11 = new JPanel();
        content11.setLayout(new FlowLayout());
        content11.setBackground(Color.decode("#5d86ec"));
        content11.add(b_addToCart);

        JPanel content12 = new JPanel();
        content12.setLayout(new FlowLayout());
        content12.setBackground(Color.decode("#5d86ec"));
        ta_cart.setEditable(false);
        content12.add(ta_cart);

        JPanel content13 = new JPanel();
        content13.setLayout(new FlowLayout());
        content13.setBackground(Color.decode("#5d86ec"));
        content13.add(new JLabel("Total price: "));
        tf_totalPrice.setEditable(false);
        content13.add(tf_totalPrice);
        content13.add(b_order);

        JPanel content14 = new JPanel();
        content14.setLayout(new FlowLayout());
        content14.setBackground(Color.decode("#5d86ec"));
        content14.add(b_logout);
        content14.add(b_exit);

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
        content.add(content11);
        content.add(content12);
        content.add(content13);
        content.add(content14);

        this.setContentPane(content);
        this.pack();
        this.setTitle("Client");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 600);
    }

    public String getTf_searchIngredient() {
        return tf_searchIngredient.getText();
    }
    public String getTf_searchRating() {
        return tf_searchRating.getText();
    }
    public String getTf_searchCalories() {
        return tf_searchCalories.getText();
    }
    public String getTf_searchProteins() {
        return tf_searchProteins.getText();
    }
    public String getTf_searchFats() {
        return tf_searchFats.getText();
    }
    public String getTf_searchSodium() {
        return tf_searchSodium.getText();
    }
    public String getTf_searchPrice() {
        return tf_searchPrice.getText();
    }

    public String[] getProductName()
    {
        String[] name = new String[15000];
        int i = 0;
        try(BufferedReader br = new BufferedReader(new FileReader("products.csv")))
        {
            String line;
            while((line = br.readLine()) != null)
            {
                String[] parts = line.split(",");
                name[i] = parts[0];
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }

   public void putToCart()
   {
       DeliveryService service = menu.getR();
       String prod = cb_product.getSelectedItem().toString();
       if(ta_cart.getText().equals(""))//face order doar daca text area e gol !!!!!!!! tre sa il golesc dupa ce apas order
       {
           doOrder(login.getTf_username());
       }
       service.addItemToOrder(service.getMenu(prod),service.getOrder(idOrder));
       ta_cart.append(prod + "\n");
       doPrice();
   }

   public void doOrder(String name)
   {
       idOrder++;
       LocalDateTime date = LocalDateTime.now();
       DeliveryService service = menu.getR();
       service.createOrder(idOrder,date,name);
   }

   //apeleaza functia de computePrice si pune in textfield pretul total
   public void doPrice()
   {
       DeliveryService service = menu.getR();
       int price = service.computePrice(service.getOrder(idOrder));
       tf_totalPrice.setText(String.valueOf(price));
   }

   public void send()
   {
       DeliveryService service = menu.getR();
       service.sendOrder(service.getOrder(idOrder));
       ta_cart.setText("");
       tf_totalPrice.setText("");
       subject.notifyObs();
   }

   //metoda care apeleaza doSearch-ul cu labda din deliveryService si pune elementele filtrate in combobox
   public void search()
   {
       DeliveryService service = menu.getR();
       ArrayList<MenuItem> m = service.doSearch(getTf_searchIngredient(),getTf_searchRating(),getTf_searchProteins(),getTf_searchCalories(),getTf_searchFats(),getTf_searchSodium(),getTf_searchPrice());
       cb_product.removeAllItems();
       for(MenuItem menu : m)
       {
           cb_product.insertItemAt(menu.getTitle(),cb_product.getItemCount());
       }
   }

   //metoda care apeleaza functia de generateBill
   public void bill()
   {
       DeliveryService service = menu.getR();
       service.generateBill(idOrder);
   }

}
