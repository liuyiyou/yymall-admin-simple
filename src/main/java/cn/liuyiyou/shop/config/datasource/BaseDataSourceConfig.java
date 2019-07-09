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
@MapperScan(basePackages = BaseDataSourceConfig.BASE_PACKAGE, sqlSessionFactoryRef = "baseSqlSessionFactory")
public class BaseDataSourceConfig extends AbstractDataSourceConfig {

    static final String BASE_PACKAGE = "cn.liuyiyou.shop.base.mapper";
    private static final String MAPPER_LOCATION = "classpath:cn/liuyiyou/shop/base/mapper/system/*.xml";

    @Bean(name = "baseDataSource")
    @ConfigurationProperties(prefix = "spring.jta.atomikos.datasource.base")
    public DataSource baseDataSource() {
        return new AtomikosDataSourceBean();
    }

    @Bean(name = "baseSqlSessionFactory")
    public SqlSessionFactory baseSqlSessionFactory(@Qualifier("baseDataSource") DataSource dataSource)
        throws Exception {
        return super.setSqlsessionFactory(dataSource, MAPPER_LOCATION);
    }
}
