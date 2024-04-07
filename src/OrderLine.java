public class OrderLine {
    private Product product;
    private int quantity;

    public OrderLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double calculateStandardUnitPrice() {
        double unitCost = product.getUnitCost();
        double markup = product.getMarkup();
        double standardUnitPrice;

        if (product.getId() == 1 || product.getId() == 2) {
            standardUnitPrice = unitCost * (1 + markup);
        } else {
            standardUnitPrice = unitCost + markup;
        }

        return Math.round(standardUnitPrice * 100.0)/100.0;
    }

    public double calculatePromotionalUnitPrice(){
        double promotionalUnitPrice = calculateStandardUnitPrice();

        if (product.getPromotion().equals("30% off")){
            promotionalUnitPrice *= 0.7;
        } else if(product.getPromotion().equals("Buy 2, get 3rd free") && quantity >= 3){
            int freeItems = quantity / 3;
            double totalPriceForAllItems = quantity * calculateStandardUnitPrice();
            double valueOfFreeItems = freeItems * calculateStandardUnitPrice();
            promotionalUnitPrice = (totalPriceForAllItems - valueOfFreeItems) / quantity;
        }

        return Math.round(promotionalUnitPrice * 100000.0) / 100000.0;
    }

    public double calculateLineTotal(){

        return calculatePromotionalUnitPrice() * quantity;
    }
}
