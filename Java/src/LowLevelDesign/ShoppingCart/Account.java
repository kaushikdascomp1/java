package Java.src.LowLevelDesign.ShoppingCart;

import java.util.List;

public class Account {

    String name;
    int userId;
    String password;
    String emailId;
    int mobile;
    Address address;
    AccountStatus status;

    List<CreditCard> cards;
    List<NetBanking> netBankings;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public List<CreditCard> getCards() {
        return cards;
    }

    public void setCards(List<CreditCard> cards) {
        this.cards = cards;
    }

    public List<NetBanking> getNetBankings() {
        return netBankings;
    }

    public void setNetBankings(List<NetBanking> netBankings) {
        this.netBankings = netBankings;
    }



    public boolean addProduct(Product product){
        return false;
    }
    public boolean addReview(Product product){
        return false;
    }
    public boolean resetPassword(){
        return false;
    }





}
