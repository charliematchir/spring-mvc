package com.mvc.mvccrud.domain.item;

import com.mvc.mvccrud.domain.dto.ItemParamDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ItemRepository {
    private static final Map<Long, Item> storage = new ConcurrentHashMap<>();
    private static long seq = 0L;

    public Item save(ItemParamDto paramDto) {
        Item item = paramDto.toEntity();
        item.setId(++seq);
        storage.put(item.getId(), item);
        return item;
    }

    public void update(Long itemId, ItemParamDto updateParam) {
        Item item = findById(itemId);
        item.updateInfo(updateParam.getPrice(), updateParam.getQuantity());
    }

    public List<Item> findAll() {
        return new ArrayList<>(storage.values());
    }

    public Item findById(Long sequence) {
        return storage.get(sequence);
    }

    public void clearStore() {
        storage.clear();
    }
}
