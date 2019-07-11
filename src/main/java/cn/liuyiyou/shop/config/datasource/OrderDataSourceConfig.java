package cn.liuyiyou.shop.config.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = OrderDataSourceConfig.BASE_PACKAGE, sqlSessionFactoryRef = "orderSqlSessionFactory")
public class OrderDataSourceConfig extends AbstractDataSourceConfig {

    static final String BASE_PACKAGE = "cn.liuyiyou.shop.order.mapper";
    private static final String MAPPER_LOCATION = "classpath:/cn/liuyiyou/shop/order/mapper/xml/*.xml";

    @Bean(name = "orderDataSource")
    @ConfigurationProperties(prefix = "spring.jta.atomikos.datasource.order")
    public DataSource orderDataSource() {
        return new AtomikosDataSourceBean();
    }

    @Bean(name = "orderSqlSessionFactory")
    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("orderDataSource") DataSource dataSource)
            throws Exception {
        return super.setSqlsessionFactory(dataSource, MAPPER_LOCATION);
    }
}
