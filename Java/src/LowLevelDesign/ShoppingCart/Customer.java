package Java.src.LowLevelDesign.ShoppingCart;

public abstract class Customer {

    ShoppingCart cart;
    Order order;

    public ShoppingCart getShoppingCart(){
        return this.getShoppingCart();
    }

    public Order getOrder(int orderId){
        return this.order;
    }

    public boolean addItemToCart(Item item){
        return false;
    }

    public boolean removeItemFromCart(Item item){
        return false;
    }
}
