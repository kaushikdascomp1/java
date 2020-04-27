package com.interview.java.designpatterns.vendingmachine.model;

public class Item {

    private int itemId;

    private int count;
    private String itemDesc;
    private int price;

    public Item(int itemId, String itemDesc, int price){
        this.itemId = itemId;
        this.itemDesc = itemDesc;
        this.price = price;
    }

    public Item(int itemId, int count){
        this.itemId = itemId;
        this.count = count;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemDesc='" + itemDesc + '\'' +
                ", price=" + price +
                '}';
    }
}
