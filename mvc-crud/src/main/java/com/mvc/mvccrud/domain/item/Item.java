package com.mvc.mvccrud.domain.item;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Item {
    private Long id;
    private String name;
    private Integer price;
    private Integer quantity;

    @Builder
    public Item(Long id, String name, Integer price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void updateInfo(Integer price, Integer quantity) {
        this.price = price;
        this.quantity = quantity;
    }
}
