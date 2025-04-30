package dev.sandeep.ProductServiceApr25.dto;

public class ProductDescDTO {
    private String productName;
    private String productDesc;

    public ProductDescDTO(String productName, String productDesc) {
        this.productName = productName;
        this.productDesc = productDesc;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }
}
