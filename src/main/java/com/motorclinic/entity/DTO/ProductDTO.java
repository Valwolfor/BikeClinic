package com.motorclinic.entity.DTO;

import java.math.BigDecimal;

public class ProductDTO {

    private Long idProduct;
    private String productName;
    private BigDecimal productValue;
    private int quantity;

    public ProductDTO(){

    }

    public ProductDTO(Long idProduct, String productName, BigDecimal productValue, int quantity) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.productValue = productValue;
        this.quantity = quantity;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductValue() {
        return productValue;
    }

    public void setProductValue(BigDecimal productValue) {
        this.productValue = productValue;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
