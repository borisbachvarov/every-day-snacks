public class Product {
    private int id;
    private String name;
    private double unitCost;
    private double markup;
    private String promotion;

    public Product(int id, String name, double unitCost, double markup, String promotion) {
        this.id = id;
        this.name = name;
        this.markup = markup;
        this.unitCost = unitCost;
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

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
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
