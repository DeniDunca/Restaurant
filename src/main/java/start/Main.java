package start;

import business.Subject;
import presentation.*;

public class Main {
    public static void main(String[] args){

        Subject subject = new Subject();
        LogIn login = new LogIn();
        Menu menu = new Menu();
        Administrator administrator = new Administrator(menu);
        Employee employee = new Employee(menu);
        Client client = new Client(menu, login, subject, employee);
        Composite composite = new Composite(administrator, menu);

        Controller controller = new Controller(administrator,client,employee, login, menu, composite);

        login.setVisible(true);

    }
}
