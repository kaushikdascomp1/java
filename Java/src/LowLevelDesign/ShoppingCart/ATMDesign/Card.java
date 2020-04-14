package Java.src.LowLevelDesign.ShoppingCart.ATMDesign;

import java.util.Objects;

public class Card {

    public int cardNo;
    public int cvv;
    public String expiry;
    public String name;
    public int pin;

    public Card(int cardNo, int cvv, String expiry, String name){

    }

    public int getCardNo() {
        return cardNo;
    }

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return cardNo == card.cardNo &&
                cvv == card.cvv &&
                pin == card.pin &&
                expiry.equals(card.expiry) &&
                name.equals(card.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNo, cvv, expiry, name, pin);
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardNo=" + cardNo +
                ", cvv=" + cvv +
                ", expiry='" + expiry + '\'' +
                ", name='" + name + '\'' +
                ", pin=" + pin +
                '}';
    }
}
