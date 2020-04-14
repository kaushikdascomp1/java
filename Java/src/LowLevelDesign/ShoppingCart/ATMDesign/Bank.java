package Java.src.LowLevelDesign.ShoppingCart.ATMDesign;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    String bankName;
    String ifscCode;
    Map<Card, Integer> validCardDetails;

    public Bank(){
        validCardDetails = new HashMap<>();
        //Card card1 = new Card()
        //validCardDetails.put()
    }
    //authenticate user

    public boolean authenticateUser(Card card){
        //
        return false;
    }

    //Transfer use hashmap of user, balance
}
