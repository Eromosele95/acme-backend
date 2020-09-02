package acme.inventoryservicepersistence.config;


import acme.inventoryservicepersistence.mappers.ItemMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "acme.inventoryservicepersistence")
public class PersistenceConfig {

    @Bean
    public DataSource datasource(){
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("inventory.sql")
                .addScript("populate.sql")
                .build();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {

        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(datasource());
        return factoryBean.getObject();
    }

    @Bean
    public MapperFactoryBean<ItemMapper> itemMapperMapperFactoryBean() throws Exception {

        MapperFactoryBean<ItemMapper> factoryBean = new MapperFactoryBean<>(ItemMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactory());
        return factoryBean;
    }

}
