package com.movies.fullstackbackend.model;

import jakarta.persistence.*;

@Entity
public class FoodVendor {
    @Id
    @GeneratedValue
    private Long id;
    private String shopName;
    private String openTime;
    private String closeTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    @OneToOne
    @JoinColumn(name="Menu",referencedColumnName = "menuId")
    private Menu menu;
}
