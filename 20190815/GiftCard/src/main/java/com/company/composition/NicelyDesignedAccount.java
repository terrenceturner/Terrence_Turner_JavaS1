package com.company.composition;

public class BetterAccount {
​
    private String firstName;
    private String lastName;
    private String username;
​
    private Address homeAddress;
    private Address shippingAddress;

    private GiftCard myGiftCard;




    public GiftCard getMyGiftCard() {
        return myGiftCard;
    }

    public void setMyGiftCard(GiftCard myGiftCard) {
        this.myGiftCard = myGiftCard;
    }​


    public String getFirstName() {
        return firstName;
    }
​
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
​
    public String getLastName() {
        return lastName;
    }
​
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
​
    public String getUsername() {
        return username;
    }
​
    public void setUsername(String username) {
        this.username = username;
    }
​
    public Address getHomeAddress() {
        return homeAddress;
    }
​
    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }
​
    public Address getShippingAddress() {
        return shippingAddress;
    }
​
    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }


    public static void main(String[] args) {

        NicelyDesignedAccount myacct = new NicelyDesignedAccount();
        GiftCard myGiftCard = new GiftCard("12345678", 1000.00);
        myacct.setMyGiftCard(myGiftCard);
        GiftCard retrieveGiftCard = myacct.getMyGiftCard();

    }


}