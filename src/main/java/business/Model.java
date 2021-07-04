package business;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class Model {

    public Model() {}

    public void showReport1(ArrayList<Order> orders, String nameFile)
    {
        File file = new File(nameFile);
        orders.forEach(System.out::println);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        FileWriter filewriter;
        BufferedWriter bufferedwriter = null;

        try {
            filewriter = new FileWriter(file.getAbsoluteFile());
            bufferedwriter = new BufferedWriter(filewriter);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            for(Order o : orders)
            {
                bufferedwriter.write( o.getId() + "\n" + o.getDate() + "\n" + o.getName() + "\n" + "-----------------------------" + "\n");
            }
            bufferedwriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showReport2(ArrayList<MenuItem> menu, String nameFile)
    {
        File file = new File(nameFile);
        menu.forEach(System.out::println);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        FileWriter filewriter;
        BufferedWriter bufferedwriter = null;

        try {
            filewriter = new FileWriter(file.getAbsoluteFile());
            bufferedwriter = new BufferedWriter(filewriter);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            for(MenuItem m : menu)
            {
                bufferedwriter.write( m.toString() + "\n");
            }
            bufferedwriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showReport3(ArrayList<String> string, String nameFile)
    {
        File file = new File(nameFile);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        FileWriter filewriter;
        BufferedWriter bufferedwriter = null;

        try {
            filewriter = new FileWriter(file.getAbsoluteFile());
            bufferedwriter = new BufferedWriter(filewriter);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            for(String s : string)
            {
                bufferedwriter.write( s + "\n");
            }
            bufferedwriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showReport4(Map<MenuItem, Long> map, String nameFile)
    {
        File file = new File(nameFile);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        FileWriter filewriter;
        BufferedWriter bufferedwriter = null;

        try {
            filewriter = new FileWriter(file.getAbsoluteFile());
            bufferedwriter = new BufferedWriter(filewriter);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            for (Map.Entry<MenuItem, Long> entry : map.entrySet()) {
                bufferedwriter.write( "Produsul " + entry.getKey() + " apare de " + entry.getValue().toString() + " ori" + "\n");
            }
            bufferedwriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
