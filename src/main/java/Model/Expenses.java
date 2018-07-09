package Model;

public class Expenses {

    private String date;
    private double price;
    private String currency;
    private String name;


    public Expenses(String date, double price, String currency, String name) {
        this.date = date;
        this.price = price;
        this.currency = currency;
        this.name = name;
    }

    public Expenses() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return date + "\n" + price + " " + currency + " " + name;
    }
}
