package com.unibuc.Spring.Project.dto.user.cart;

public class RemoveProductFromCartRequest {
    private String username;
    private String productName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
