package presentation;

import data.Serializer;
import data.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Controller {
    private Administrator administrator;
    private Client client;
    private Employee employee;
    private LogIn login;
    private Menu menu;
    private Composite composite;


    public Controller(Administrator administrator, Client client, Employee employee, LogIn login, Menu menu, Composite composite)
    {
        this.administrator = administrator;
        this.client = client;
        this.employee = employee;
        this.login = login;
        this.menu = menu;
        this.composite = composite;

        administrator.addExitListener(new ExitListener());
        administrator.addAddListener(new AddingListener());
        administrator.addDeleteListener(new DeleteListener());
        administrator.addModifyListener(new ModifyListener());
        administrator.addLogOutListener(new LogOutListener());
        administrator.addImportListener(new ImportListener());
        administrator.addCompositeListener(new CompositeListener());
        administrator.add1Listener(new Rep1Listener());
        administrator.add2Listener(new Rep2Listener());
        administrator.add3Listener(new Rep3Listener());
        administrator.add4Listener(new Rep4Listener());
        administrator.addSerialize(new SerializeListener());
        administrator.addDeserialize(new DeserializeListener());

        client.addExitListener(new ExitListener());
        client.addOrderListener(new OrderListener());
        client.addLogOutListener(new LogOutListener());
        client.addSearchListener(new SearchListener());
        client.addViewMenuListener(new ViewMenuListener());
        client.addToCartListener(new AddToCartListener());

        employee.addExitListener(new ExitListener());
        employee.addLogOutListener(new LogOutListener());

        login.addExitListener(new ExitListener());
        login.addLogInListener(new LogInListener());
        login.addSignInListener(new SignInListener());

        composite.addAddCListener(new AddCompListener());
        composite.addSaveListener(new SaveListener());

    }

    private class ExitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    private class AddingListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            administrator.add();
            menu.clientFrame();
        }
    }

    private class DeleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            administrator.delete();
            menu.clientFrame();
        }
    }

    private class ModifyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                administrator.edit();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            menu.clientFrame();
        }
    }

    private class SerializeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            administrator.serialize();
        }
    }
    private class DeserializeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            administrator.deserialize();
        }
    }

    private class OrderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

           client.send();
           client.bill();
        }
    }

    private class SearchListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

           client.search();
        }
    }

    private class AddToCartListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

           client.putToCart();
        }
    }

    private class LogInListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            User user = new User();
            String nume = login.getTf_username();
            String parola = login.getTf_password();

            if(user.getRole(nume, parola) == null)
            {
                JOptionPane.showMessageDialog(login, "You don't have an account!");
            }
            else
            {
                if (user.getRole(nume, parola).equals("administrator"))
                {
                    administrator.setVisible(true);
                }
                else if(user.getRole(nume, parola).equals("client"))
                {
                    client.setVisible(true);
                }
                else if(user.getRole(nume, parola).equals("employee"))
                {
                    employee.setVisible(true);
                }
                else if( user.getRole(nume, parola).equals("not match"))
                {
                    JOptionPane.showMessageDialog(login, "Username and password don't match!");
                }
            }

        }
    }

    private class LogOutListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            administrator.setVisible(false);
            client.setVisible(false);
            employee.setVisible(false);
            login.setVisible(true);
            menu.invisibleFrame();
        }
    }

    private class SignInListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            User user = new User();
            String nume = login.getTf_username();
            String parola = login.getTf_password();
            try {
                if(!user.verifyUsername(nume))
                {
                    user.signIn(nume, parola);
                }
                else
                {
                    JOptionPane.showMessageDialog(login, "There is already an account with this username");
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }
    }

    private class ViewMenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            menu.clientFrame();
        }
    }

    private class  AddCompListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

           composite.addProd();
        }
    }
    private class SaveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            composite.save();
        }
    }

    private class ImportListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            menu.importFrame();
        }
    }

    private class CompositeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            composite.setVisible(true);
        }
    }

    private class Rep1Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            administrator.report1();
        }
    }

    private class Rep2Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            administrator.report2();
        }
    }

    private class Rep3Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            administrator.report3();
        }
    }

    private class Rep4Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            administrator.report4();
        }
    }

}
