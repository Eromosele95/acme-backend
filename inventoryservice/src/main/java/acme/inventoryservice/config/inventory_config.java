package acme.inventoryservice.config;


import acme.inventoryservicepersistence.config.PersistenceConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "acme.inventoryservice")

@Import(PersistenceConfig.class)
public class inventory_config {



}
