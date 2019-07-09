package cn.liuyiyou.shop.config.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = SystemDataSourceConfig.BASE_PACKAGE, sqlSessionFactoryRef = "systemSqlSessionFactory")
public class SystemDataSourceConfig extends AbstractDataSourceConfig {

    static final String BASE_PACKAGE = "cn.liuyiyou.shop.system.mapper";
    private static final String MAPPER_LOCATION = "classpath:cn/liuyiyou/shop/system/mapper/system/*.xml";

    @Bean(name = "systemDataSource")
    @ConfigurationProperties(prefix = "spring.jta.atomikos.datasource.system")
    @Primary
    public DataSource systemDataSource() {
        return new AtomikosDataSourceBean();
    }

    @Bean(name = "systemSqlSessionFactory")
    @Primary
    public SqlSessionFactory systemSqlSessionFactory(@Qualifier("systemDataSource") DataSource dataSource)
        throws Exception {
        return super.setSqlsessionFactory(dataSource, MAPPER_LOCATION);
    }


}
