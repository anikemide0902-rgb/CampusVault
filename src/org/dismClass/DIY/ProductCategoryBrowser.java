package org.dismClass.DIY;

import java.io.Serializable;

public class ProductCategoryBrowser implements Serializable {

    private static final long serialVersionUID = 1L;

    private int productId;
    private String productName;
    private double price;

    public ProductCategoryBrowser(int productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId
                + "\nProduct Name: " + productName
                + "\nPrice: ₦" + price;
    }
}