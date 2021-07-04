package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LogIn extends JFrame {

    private JButton b_login = new JButton("LOG IN");
    private JButton b_signin = new JButton("SIGN IN");
    private JButton b_exit = new JButton("EXIT");

    private JTextField tf_username = new JTextField(20);
    private JPasswordField tf_password = new JPasswordField(20);

    public void addExitListener(ActionListener exit)
    {
        b_exit.addActionListener(exit);
    }
    public void addLogInListener(ActionListener logIn) { b_login.addActionListener(logIn);}
    public void addSignInListener(ActionListener signIn) { b_signin.addActionListener(signIn);}

    public LogIn()
    {
        JPanel content0 = new JPanel();
        content0.setLayout(new FlowLayout());
        content0.setBackground(Color.decode("#5d86ec"));
        content0.add(new JLabel("Welcome!"));
        content0.add(new JLabel("Please, enter your username and password!"));

        JPanel content1 = new JPanel();
        content1.setLayout(new FlowLayout());
        content1.setBackground(Color.decode("#5d86ec"));
        content1.add(new JLabel("Username: "));
        content1.add(tf_username);

        JPanel content2 = new JPanel();
        content2.setLayout(new FlowLayout());
        content2.setBackground(Color.decode("#5d86ec"));
        content2.add(new JLabel("Password: "));
        content2.add(tf_password);

        JPanel content3 = new JPanel();
        content3.setLayout(new FlowLayout());
        content3.setBackground(Color.decode("#5d86ec"));
        content3.add(b_login);
        content3.add(b_signin);
        content3.add(b_exit);

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.add(content0);
        content.add(content1);
        content.add(content2);
        content.add(content3);

        this.setContentPane(content);
        this.pack();
        this.setTitle("Log In");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);

    }

    public String getTf_username() {
        return tf_username.getText();
    }
    public String getTf_password() {
        return tf_password.getText();
    }
}
