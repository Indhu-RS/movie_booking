package com.movies.fullstackbackend.model;

import jakarta.persistence.*;

@Entity
public class Menu {
    @Id
    @GeneratedValue
    
        private Long menuId;
        private String itemName;
        private double price;
        private String imageUrl;
    
        public Long getMenuId() {
            return menuId;
        }
    
        public void setMenuId(Long menuId) {
            this.menuId = menuId;
        }
    
        public String getItemName() {
            return itemName;
        }
    
        public void setItemName(String itemName) {
            this.itemName = itemName;
        }
    
        public double getPrice() {
            return price;
        }
    
        public void setPrice(double price) {
            this.price = price;
        }
    
        public String getImageUrl() {
            return imageUrl;
        }
    
        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }
    }
    