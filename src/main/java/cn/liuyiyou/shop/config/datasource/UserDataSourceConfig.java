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
@MapperScan(basePackages = UserDataSourceConfig.BASE_PACKAGE, sqlSessionFactoryRef = "userSqlSessionFactory")
public class UserDataSourceConfig extends AbstractDataSourceConfig {

    static final String BASE_PACKAGE = "cn.liuyiyou.shop.user.mapper";
    private static final String MAPPER_LOCATION = "classpath:/cn/liuyiyou/shop/user/mapper/xml/*.xml";

    @Bean(name = "userDataSource")
    @ConfigurationProperties(prefix = "spring.jta.atomikos.datasource.user")
    public DataSource userDataSource() {
        return new AtomikosDataSourceBean();
    }

    @Bean(name = "userSqlSessionFactory")
    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("userDataSource") DataSource dataSource)
            throws Exception {
        return super.setSqlsessionFactory(dataSource, MAPPER_LOCATION);
    }
}
