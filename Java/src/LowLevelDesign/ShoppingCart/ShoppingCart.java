package Java.src.LowLevelDesign.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    List<Item> items;

    public boolean addItem(Item item) {
        return false;
    }

    public boolean removeItem(Item item) {
        return false;
    }

    public boolean updateItemQty(Item item, int qty){
        return false;
    }

    public List<Item> getItems(){
        return new ArrayList<>();
    }

    public boolean checkout(){
        return false;
    }
}
