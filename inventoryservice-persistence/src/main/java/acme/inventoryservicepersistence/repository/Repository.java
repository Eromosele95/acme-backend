package acme.inventoryservicepersistence.repository;

import acme.inventoryservicepersistence.entities.ItemEntity;
import acme.inventoryservicepersistence.mappers.ItemMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Repository {

    private final ItemMapper itemMapper;

    public Repository(ItemMapper itemMapper){
        this.itemMapper = itemMapper;
    }

    public List<ItemEntity> getAllItems(){
        return itemMapper.getAllItems();
    }
}
