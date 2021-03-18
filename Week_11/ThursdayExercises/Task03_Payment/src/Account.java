public class Account {
    String transactionDate;
    String product;
    double price;
    String paymentType;
    long cardNumber;
    String name;
    String city;
    String state;
    String country;
    String accountCreated;
    String lastLogin;
    String latitude;
    String longitude;

    public Account(String transactionDate, String product, double price, String paymentType, long cardNumber, String name,
                   String city, String state, String country, String accountCreated, String lastLogin, String latitude, String longitude) {
        this.transactionDate = transactionDate;
        this.product = product;
        this.price = price;
        this.paymentType = paymentType;
        this.cardNumber = cardNumber;
        this.name = name;
        this.city = city;
        this.state = state;
        this.country = country;
        this.accountCreated = accountCreated;
        this.lastLogin = lastLogin;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        String returnString =
                "Transaction date: \t\t"+ transactionDate +
                "\nProduct: \t\t\t\t"+ product +
                "\nPrice: \t\t\t\t\t"+ price +
                "\nPayment type: \t\t\t"+ paymentType +
                "\nCard number: \t\t\t"+ cardNumber +
                "\nName: \t\t\t\t\t"+ name +
                "\nCity: \t\t\t\t\t"+ city +
                "\nState: \t\t\t\t\t"+ state +
                "\nCountry: \t\t\t\t"+ country +
                "\nAccount Created: \t\t"+ accountCreated +
                "\nLast Login: \t\t\t"+ lastLogin +
                "\nLatitude: \t\t\t\t"+ latitude +
                "\nLongitude: \t\t\t\t"+ longitude;
        return returnString;
    }
}
