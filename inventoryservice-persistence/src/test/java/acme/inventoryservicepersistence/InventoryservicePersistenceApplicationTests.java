package acme.inventoryservicepersistence;

import acme.inventoryservicepersistence.config.PersistenceConfig;

import acme.inventoryservicepersistence.entities.ItemEntity;
import acme.inventoryservicepersistence.repository.Repository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = PersistenceConfig.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@MybatisTest

public class InventoryservicePersistenceApplicationTests {
    @Autowired
	private Repository repo;
    
    
    @Test
    void contextLoads() {


    }

    @Test
    void TestingRetreival(){
        try{
            System.out.println(repo.getAllItems().size());
//            for(ItemEntity e: repo.getAllArticles()){
//                System.out.println(e.toString());
//            }

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

}
