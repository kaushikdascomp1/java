package Java.src.LowLevelDesign.ShoppingCart.ATMDesign;

public class Printer {

    public void printReceipt(Transaction transaction){
        System.out.println("Transaction Status is: "+ transaction.getStatus());

        if(transaction.getStatus().equals(TransactionStatus.SUCCESS)){
            //print transactions in a file
        }

       //
    }
}
