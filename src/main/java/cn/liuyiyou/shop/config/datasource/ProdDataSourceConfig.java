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
@MapperScan(basePackages = ProdDataSourceConfig.BASE_PACKAGE, sqlSessionFactoryRef = "prodSqlSessionFactory")
public class ProdDataSourceConfig extends AbstractDataSourceConfig {

    static final String BASE_PACKAGE = "cn.liuyiyou.shop.prod.mapper";
    private static final String MAPPER_LOCATION = "classpath:cn/liuyiyou/shop/prod/mapper/system/*.xml";

    @Bean(name = "prodDataSource")
    @ConfigurationProperties(prefix = "spring.jta.atomikos.datasource.prod")
    public DataSource prodDataSource() {
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        return atomikosDataSourceBean;
    }

    @Bean(name = "prodSqlSessionFactory")
    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("prodDataSource") DataSource dataSource)
            throws Exception {
        return super.setSqlsessionFactory(dataSource, MAPPER_LOCATION);
    }
}
