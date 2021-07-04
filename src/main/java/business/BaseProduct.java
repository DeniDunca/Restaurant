package business;

import java.io.Serializable;

public class BaseProduct extends MenuItem implements Serializable{


    public BaseProduct(String title, double rating, int calories, int proteins, int fats, int sodium, int price) {
        super(title, rating, calories, proteins, fats, sodium, price);
    }

    @Override
    public void add(MenuItem menuItem) {

    }

    @Override
    public String toString() {
        return  title + rating + " " + calories + " " +  proteins + " " +  fats + " " +  sodium + " " +  price;
    }
}
