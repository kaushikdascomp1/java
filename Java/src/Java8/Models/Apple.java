package Java.src.Java8.Models;

public class Apple {

    public String color;
    public Double weight;

    public Apple(String color, Double weight){
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String toString(){
        return "Apple{color:" + this.getColor() + ",weight: " + this.getWeight();
    }

}
