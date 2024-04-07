package main.java;

public class Client {
    private int id;
    private String name;
    private double basicDiscount;
    private double volumeDiscountThreshold1;
    private double volumeDiscountThreshold2;

    public Client(int id, String name, double basicDiscount, double volumeDiscountThreshold1, double volumeDiscountThreshold2) {
        this.id = id;
        this.name = name;
        this.basicDiscount = basicDiscount;
        this.volumeDiscountThreshold1 = volumeDiscountThreshold1;
        this.volumeDiscountThreshold2 = volumeDiscountThreshold2;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setBasicDiscount(double basicDiscount) {
        this.basicDiscount = basicDiscount;
    }

    public double getBasicDiscount() {
        return basicDiscount;
    }
    public void setVolumeDiscountThreshold1(double volumeDiscountThreshold1) {
        this.volumeDiscountThreshold1 = volumeDiscountThreshold1;
    }

    public double getVolumeDiscountThreshold1() {
        return volumeDiscountThreshold1;
    }
    public double getVolumeDiscountThreshold2() {
        return volumeDiscountThreshold2;
    }

    public void setVolumeDiscountThreshold2(double volumeDiscountThreshold2) {
        this.volumeDiscountThreshold2 = volumeDiscountThreshold2;
    }
}
