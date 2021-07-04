package data;

import business.DeliveryService;

import java.io.*;

public class Serializer implements Serializable{

    public void serialize(DeliveryService object) {
        try {
            FileOutputStream file = new FileOutputStream("delivery.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(object);
            out.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public DeliveryService deserialize(String path) {
        DeliveryService restaurant;
        try {
            FileInputStream file = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(file);
            restaurant = (DeliveryService) in.readObject();
            in.close();
            file.close();
            return restaurant;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
