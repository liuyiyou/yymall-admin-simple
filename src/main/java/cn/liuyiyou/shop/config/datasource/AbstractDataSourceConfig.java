package cn.liuyiyou.shop.config.datasource;

import cn.liuyiyou.shop.config.mybatis.MetaObjectHandlerConfig;
import com.baomidou.mybatisplus.autoconfigure.SpringBootVFS;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author: liuyiyou.cn
 * @date: 2019/1/4
 * @version: V1.0
 */
public class AbstractDataSourceConfig {


    @Autowired
    private ObjectProvider<Interceptor[]> interceptorsProvider;
    @Autowired
    private ApplicationContext applicationContext;

    /**
     * 统一设置mybatis-plus相关属性
     * @param dataSource
     * @param mapperLocation
     * @return
     * @throws Exception
     */
    public SqlSessionFactory setSqlsessionFactory(DataSource dataSource, String mapperLocation)
        throws Exception {
        final MybatisSqlSessionFactoryBean factory = new MybatisSqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setMapperLocations(new PathMatchingResourcePatternResolver()
            .getResources(mapperLocation));
        factory.setVfs(SpringBootVFS.class);
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setMetaObjectHandler(new MetaObjectHandlerConfig());
        //注入sql注入器
        if (this.applicationContext.getBeanNamesForType(ISqlInjector.class, false,
            false).length > 0) {
            ISqlInjector iSqlInjector = this.applicationContext.getBean(ISqlInjector.class);
            globalConfig.setSqlInjector(iSqlInjector);
        }
        factory.setGlobalConfig(globalConfig);
        factory.setPlugins(interceptorsProvider.getIfAvailable());
        return factory.getObject();
    }
}
