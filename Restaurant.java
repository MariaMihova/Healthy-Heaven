package healthyHeaven;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private String name;
    private List<Salad> data;

    public Restaurant(String name) {
        this.name = name;
        this.data = new ArrayList<>();
    }

    //•	Method add(Salad salad) – adds an entity to the data
    public void add(Salad salad){
        this.data.add(salad);
    }

    //•	Method buy(String name) – removes a salad by given name, if such exists, and returns boolean
    public boolean buy(String name){
        for (Salad salad : this.data ) {
            if(name.equals(salad.getName())){
                this.data.remove(salad);
                return true;
            }
        }
        return false;
    }

    //•	Mehod getHealthiestSalad() – returns the healthiest salad
    public Salad getHealthiestSalad(){  // ????????
        int minCalories = Integer.MAX_VALUE;
        Salad healthy = null;

        for (Salad salad : this.data) {
            if(minCalories > salad.getTotalCalories()) {
                minCalories = salad.getTotalCalories();
                healthy = salad;
            }
        }
        return healthy;
    }

    //•	Method generateMenu() - returns a string in the following format:
    //"{name} have {salad count} salads:
    //{Salad 1}
    //{Salad 2}
    //{…}"

    public String generateMenu(){
        StringBuilder fill = new StringBuilder();

        fill.append(String.format("%s have %d salads:"
        , this.name, this.data.size())).append(System.lineSeparator());

        this.data.forEach(salad -> fill.append(salad.toString()).append(System.lineSeparator()));

        return fill.toString().trim();
    }

}
