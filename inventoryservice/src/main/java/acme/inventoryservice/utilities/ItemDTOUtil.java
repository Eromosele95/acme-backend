package acme.inventoryservice.utilities;

import acme.inventoryservice.models.Item;
import acme.inventoryservicepersistence.entities.ItemEntity;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;


@Component
public class ItemDTOUtil {
    public Item convertToItem(ItemEntity ie, Item i) throws InvocationTargetException, IllegalAccessException {
         BeanUtils.copyProperties(i, ie);
         return i;
    }


}
