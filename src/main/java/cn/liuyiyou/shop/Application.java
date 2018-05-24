package cn.liuyiyou.shop;

import lombok.extern.java.Log;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@MapperScan(basePackages = "cn.liuyiyou.shop.mapper")
@EnableTransactionManagement
@Log
@Configuration
public class Application {


    @Autowired
    private Environment env;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    /**
     * 该配置是在
     * <code>
     *
     * @RunWith(SpringJUnit4ClassRunner.class)
     * @ContextConfiguration(classes = Application.class)
     * </code>
     * 这个注解的时候才需要如下显示，如果使用:
     * <code>
     * @RunWith(SpringRunner.class)
     * @SpringBootTest(classes = Application.class)
     * </code>
     * 可以不需要配置，或者配置之后不要设置，由<code>ConfigurationProperties</code>自动装配
     */
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/shop?useUnicode=true&useSSL=false&characterEncoding=utf-8&rewriteBatchedStatements=true&zeroDateTimeBehavior=convertToNull")
                .username("root")
                .password("123456")
                .build();
    }


}
