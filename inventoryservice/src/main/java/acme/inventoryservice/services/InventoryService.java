package acme.inventoryservice.services;

import acme.inventoryservice.models.Item;
import acme.inventoryservice.utilities.ItemDTOUtil;
import acme.inventoryservicepersistence.entities.ItemEntity;
import acme.inventoryservicepersistence.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryService {
    @Autowired
    ItemDTOUtil ItemDTOUtil;


    private final Repository repo;

    public InventoryService(Repository r){
        this.repo = r;
    }

    public List<Item> getAllArticles() throws InvocationTargetException, IllegalAccessException {
        List<Item> ItemList = new ArrayList<>();

        for (ItemEntity ie : repo.getAllItems()){
            ItemList.add(ItemDTOUtil.convertToItem(ie,new Item()));

        }
        return ItemList;

    }


}
