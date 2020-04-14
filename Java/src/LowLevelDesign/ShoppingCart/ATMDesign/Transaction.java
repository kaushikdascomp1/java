package Java.src.LowLevelDesign.ShoppingCart.ATMDesign;

import java.util.Date;

public class Transaction {

    public int transId;
    public Date creationDate;
    public TransactionStatus status;

    public int getTransId() {
        return transId;
    }

    public void setTransId(int transId) {
        this.transId = transId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    //methods

    public boolean makeTransaction(){
        return false;
    }
}
