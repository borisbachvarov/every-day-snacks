public class Product {
    private int id;
    private String name;
    private double unitPrice;
    private double markup;
    private String promotion;

    public Product(int id, String name, double unitPrice, double markup, String promotion) {
        this.id = id;
        this.name = name;
        this.markup = markup;
        this.unitPrice = unitPrice;
        this.promotion = promotion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getMarkup() {
        return markup;
    }

    public void setMarkup(double markup) {
        this.markup = markup;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }


}
