package com.interview.java.designpatterns.vendingmachine;

import com.interview.java.designpatterns.vendingmachine.model.Item;
import com.interview.java.designpatterns.vendingmachine.payment.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {


    public static Logger log = LoggerFactory.getLogger(VendingMachine.class);
    private static final int MAX_ITEMS = 16;
    private int noOfItems;
    List<Item> itemList;

    @Autowired
    public Payment paymentMethod;


    public VendingMachine(int noOfItems){
        this.noOfItems = noOfItems;
        itemList = new ArrayList<>();

        //this.paymentMethod = payment;
        intializeItems();
    }

    //initialize items
    public void intializeItems(){
        for (int i = 0; i< noOfItems ; i++) {
            itemList.add(new Item(i,12));
        }
    }

    public boolean purchaseItem(int itemNo, int amount){
        Item item;
        //validate the item no
        for(Item itemL:itemList){
            if (itemL.getItemId() == itemNo){
                item = itemL;
                //check if the count of the item is > 0 then make payment
                boolean status = paymentMethod.doPayment(amount);
                if(status){
                    int count = itemL.getCount();
                    itemL.setCount(count--);
                    itemList.add(itemL);
                    return true;
                }else{
                    //return change
                }

            }else{
                log.info("Item Id not found");
                return false;
            }

        }

       // purchase using payment method
       return false;
    }

    //remove item
    //add items to vending machine


}
