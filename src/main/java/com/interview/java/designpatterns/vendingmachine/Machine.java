package com.interview.java.designpatterns.vendingmachine;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Machine {

    public Map<String, Item> stock;
    public TreeMap<Double, Integer> change;
    public Map<Integer, String> menu;

    private double userMoney;

    public Machine() {
        this.stock = new HashMap<>();
        this.change = new TreeMap<>();
        this.menu = new HashMap<>();
        this.userMoney = 0;
    }


    //Admin Related Tasks
    //loadItems
    //loadChange
    //getMachineTotal

    //Machine Related Tasks
    //buyitem
    //dispenseItem
    //makeChange

    public double getUserMoney(){
        return userMoney;
    }

    public void loadItems(String name, Double price, Integer quantity) {
        if (stock.containsKey(name)) {
            Item current = stock.get(name);
            current.setQuantity(current.getQuantity() + quantity);
            stock.put(name, current);
        } else {
            Item item = new Item(name, price, quantity);
            stock.put(name, item);
        }
    }

    public void loadChange(Double currencyNote, Integer quantity) {
        change.put(currencyNote, change.getOrDefault(currencyNote, quantity) + quantity);
    }

    public double getMachineTotal() {
        double totalSum = change.entrySet().stream().mapToDouble(e -> e.getKey() * e.getValue()).sum();
        return totalSum;
    }


    //Machine related methods
    public Item buyItem(Integer sel, Double amount){
        if(menu.containsKey(sel)){
            Item item = stock.get(menu.get(sel));
            Double price = item.getPrice();
            if(amount > price){
                    //dispense Item
                if((amount - price) < getMachineTotal()){
                    dispenseItem(item);
                    makeChange(amount-price);
                    this.userMoney = amount - price;
                    return item;
                }else {
                    System.out.println("Not enough Change left:: Cannot dispense Item");
                }

            }else {
                System.out.println("Insufficient Funds:: Please enter more::"+(price-amount));
            }
        }
        return null;
    }

    public void dispenseItem(Item item){
        item.setQuantity(item.getQuantity()-1);
    }

    public void makeChange(double needed){
        System.out.println("Change Needed is:: "+ needed);
        double temp = needed;
        for (Double value:this.change.descendingKeySet()){
            int numCoins =  (int)(temp / value.doubleValue());
            temp = temp % value;
            if(numCoins > 0){
                int old = change.get(value).intValue();
                if(numCoins < old){
                    change.put(value,old-numCoins);
                    System.out.println("Please take your change:: "+ numCoins);
                }
            }

        }
    }

}
