package com.mvc.mvccrud.domain.dto;

import com.mvc.mvccrud.domain.item.Item;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemParamDto {
    private Long id;
    private String name;
    private Integer price;
    private Integer quantity;

    @Builder
    public ItemParamDto(Item entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.price = entity.getPrice();
        this.quantity = entity.getQuantity();
    }

    public Item toEntity() {
        return Item.builder()
                .name(name)
                .price(price)
                .quantity(quantity)
                .build();
    }
}
