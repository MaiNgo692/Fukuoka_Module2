public class Product {
    private String id;
    private String name;
    private double price;
    private  double discount;
    private  double salePrice;

    public Product() {
    }

    public Product(String id, String name, double price, double discount, double salePrice) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.salePrice = salePrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSalePrice() {
        return this.salePrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void calculateSalePrice(){
        this.salePrice = this.price - (this.price/100*this.discount);
    }
    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

}
