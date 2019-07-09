package cn.liuyiyou.shop;

import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

//import cn.liuyiyou.shop.filter.JwtAuthorizeFilter;

@SpringBootApplication
@EnableTransactionManagement
@Slf4j
@Configuration
@EnableSwagger2
//@EnableConfigurationProperties({JwtProperty.class, JwtPatternUrl.class})  //加载自定义的properties解析类
public class Application implements WebMvcConfigurer {


    @Autowired
    private Environment env;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("一优商城RESTful APIs")
                .description("使用Swagger2创建")
                .termsOfServiceUrl("http://localhost:9999/")
                .version("1.0")
                .build();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    static String dateFormat = "yyyy-MM-dd HH:mm:ss";

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter fastConverter =
                new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        SerializeConfig serializeConfig = SerializeConfig.globalInstance;
        serializeConfig.put(BigInteger.class, ToStringSerializer.instance);
        serializeConfig.put(Long.class, ToStringSerializer.instance);
        serializeConfig.put(Date.class, new SimpleDateFormatSerializer(dateFormat));
        fastJsonConfig.setSerializeConfig(serializeConfig);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        converters.add(fastConverter);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
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
//    @Bean
//    @Primary
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource mysqlDataSource() {
//        return DataSourceBuilder.create()
//                .driverClassName("com.mysql.jdbc.Driver")
//                .url("jdbc:mysql://localhost:3306/shop?useUnicode=true&useSSL=false&characterEncoding=utf-8&rewriteBatchedStatements=true&zeroDateTimeBehavior=convertToNull")
//                .username("root")
//                .password("123456")
//                .build();
//    }


    /*
     * 注册过滤器类和过滤的url
     */
//    @Bean
//    public FilterRegistrationBean basicFilterRegistrationBean() {
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
////        JwtAuthorizeFilter filter = new JwtAuthorizeFilter();
//        registrationBean.setFilter(filter);
//        List<String> urlPatterns = new ArrayList<>();
//        urlPatterns.add("/*");
//        registrationBean.setUrlPatterns(urlPatterns);
//        return registrationBean;
//    }


    /**
     java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
     * @return
     */
//    @Bean
//    public static NoOpPasswordEncoder passwordEncoder() {
//        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//    }
}
