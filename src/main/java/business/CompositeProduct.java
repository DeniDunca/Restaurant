package business;


import java.io.Serializable;

public class CompositeProduct extends MenuItem implements Serializable {

    public CompositeProduct(String title, double rating, int calories, int proteins, int fats, int sodium, int price) {
        super(title, rating, calories, proteins, fats, sodium, price);
    }

    @Override
    public void add(MenuItem menuItem) {
        this.rating = this.rating + menuItem.rating;
        this.calories = this.calories + menuItem.calories;
        this.proteins = this.proteins + menuItem.proteins;
        this.fats = this.fats + menuItem.fats;
        this.sodium = this.sodium + menuItem.sodium;
        this.price = this.price + menuItem.price;
    }
}
