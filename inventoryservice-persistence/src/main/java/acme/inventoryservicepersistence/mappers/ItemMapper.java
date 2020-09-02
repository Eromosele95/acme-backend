package acme.inventoryservicepersistence.mappers;

import acme.inventoryservicepersistence.entities.ItemEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ItemMapper {
    @Select("SELECT * FROM ITEMS;")
    List<ItemEntity> getAllItems();


}
