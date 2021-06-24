package healthyHeaven;

import java.util.ArrayList;
import java.util.List;

public class Salad {
    private String name;
    private List<Vegetable> products;//???

    public Salad(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    //•	Method getTotalCalories() – returns the sum of all vegetable calories in the salad
    public int getTotalCalories(){
        int calories = this.products.stream().mapToInt(Vegetable::getCalories).sum();
        return calories;
    }

    //•	Method getProductCount() - returns the number of products
    public int getProductCount(){
        return this.products.size();
    }

    //•	Method add(Vegetable product) – adds an entity to the products
    public void add(Vegetable product){
        this.products.add(product);
    }

    //•	Override toString() – by the format bellow:
    //"* Salad {name} is {calories} calories and have {product count} products:
    //{Vegetable 1}
    //{Vegetable 2}
    //{Vegetable 3}
    //{…}"

    @Override
    public String toString(){
        StringBuilder fill = new StringBuilder();
        fill.append(String.format("* Salad %s is %d calories and have %d products:"
        ,this.getName(), this.getTotalCalories(), this.getProductCount())).append(System.lineSeparator());

        this.products.forEach(product -> fill.append(product.toString()).append(System.lineSeparator()));

        return fill.toString().trim();

    }
}
