package com.interview.java.designpatterns;

import com.interview.java.designpatterns.vendingmachine.Item;
import com.interview.java.designpatterns.vendingmachine.Machine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VendingMachineTest {

    Machine vedingMachine;

    @BeforeEach
    public void setup(){
        vedingMachine = new Machine();
        loadMenu();
        loadChange();
        loadItems();
    }

    @Test
    public void buyItemSuccessTest(){
        //given
        Integer rackNo = 2;
        double money = 4d;

        //when
        Item boughtItem = vedingMachine.buyItem(rackNo, money);

        //then
        Assertions.assertEquals(0.8d,Math.round(vedingMachine.getUserMoney()*100.0)/100.0);
        Item item = vedingMachine.stock.get(vedingMachine.menu.get(rackNo));
        Assertions.assertEquals(6,item.getQuantity());
        Assertions.assertEquals("KitKat",boughtItem.getName());
    }

    @Test
    public void buyItemFailureTestInsufficientFunds(){
        //given
        Integer rackNo = 2;
        double money = 2d;

        //when
        Item boughtItem = vedingMachine.buyItem(rackNo, money);

        //then
        Assertions.assertNull(boughtItem);
    }

    public void loadMenu(){
        vedingMachine.menu.put(1, "Snickers");
        vedingMachine.menu.put(2, "KitKat");
        vedingMachine.menu.put(3, "DietCoke");
        vedingMachine.menu.put(4, "Sprite");
        vedingMachine.menu.put(5,"Skittles");
        vedingMachine.menu.put(6,"Starbust");
        vedingMachine.menu.put(7,"Muffin");
    }

    public void loadChange(){
        vedingMachine.loadChange(0.01, 100);
        vedingMachine.loadChange(0.02, 100);
        vedingMachine.loadChange(0.05, 100);
        vedingMachine.loadChange(0.1, 100);
        vedingMachine.loadChange(0.2, 100);
        vedingMachine.loadChange(0.5, 100);
        vedingMachine.loadChange(1.0, 100);
        vedingMachine.loadChange(2.0, 100);
    }

    public void loadItems(){
        vedingMachine.loadItems("Snickers", 2.0, 3);
        vedingMachine.loadItems("KitKat", 3.20, 7);
        vedingMachine.loadItems("Skittles", 1.75, 5);
        vedingMachine.loadItems("Muffin", 4.0, 15);
        vedingMachine.loadItems("Starbust", 1.5, 5);
        vedingMachine.loadItems("Sprite", 2.15, 12);
        vedingMachine.loadItems("DietCoke", 1.75, 30);
    }
}
