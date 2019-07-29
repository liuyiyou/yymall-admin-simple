package cn.liuyiyou.shop;

/**
 * @author: liuyiyou.cn
 * @date: 2019/7/9
 * @version: V1.0
 */

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.ITypeConvert;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.Test;

import static com.baomidou.mybatisplus.annotation.IdType.INPUT;

/**
 * 这个是新版本的
 *
 * @author liuyiyou.cn
 * @date 18-7-9
 * <p>
 * 代码生成器配置 https://mp.baomidou.com/config/generator-config.html#%E5%9F%BA%E6%9C%AC%E9%85%8D%E7%BD%AE
 */
public class CodeGenerate {

    private final static String AUTHOR = "liuyiyou.cn";
    private final static String OUTPUT_DIR = "/Users/liuyiyou/code/github/cn.liuyiyou.shop.simple/src/main/java";
    private final static String BASE_PACKAGE = "cn.liuyiyou.shop";


    private final static String MODULE_NAME = "user";
    private final static String[] TABLES = {"user_delivery"};
    private final static String DB_URL = "jdbc:mysql://localhost:3306/shop-user?useUnicode=true&characterEncoding=utf-8&rewriteBatchedStatements=true&zeroDateTimeBehavior=convertToNull";
    private final static String DB_USERNAME = "root";
    private final static String DB_PASSWORD = "123456";

    private final static boolean IS_USE_REDIS_CACHE = false;

    @Test
    public void generateCode() {
        generateByTables();
    }

    private void generateByTables() {
        AutoGenerator generator = new AutoGenerator();
        generator.setTemplateEngine(getTemplateEngine()) // 选择 freemarker 引擎，默认 Veloctiy
                .setPackageInfo(getPackageConfig())
                .setDataSource(getDataSourceConfig())
                .setStrategy(getStrategyConfig())
                .setGlobalConfig(getGlobalConfig());
        generator.execute();
    }

    private FreemarkerTemplateEngine getTemplateEngine() {
        return new FreemarkerTemplateEngine();
    }

    private GlobalConfig getGlobalConfig() {
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(false)//是否继承Model类,集成Redis缓存必须为false
                .setBaseResultMap(true)
                .setBaseColumnList(true)
                .setAuthor(AUTHOR)
                .setOutputDir(OUTPUT_DIR)
                .setFileOverride(true)
                .setIdType(INPUT)
                .setOpen(false);
        config.setServiceName("%sService");
        return config;
    }

    private StrategyConfig getStrategyConfig() {
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)
                .setEntityLombokModel(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setEntityColumnConstant(true)
                .setRestControllerStyle(true)
                //.setSuperMapperClass("com.youngboss.flashsale.util.parent.BaseMapper")
                .setInclude(TABLES)
                .setLogicDeleteFieldName("deleted");
        if (IS_USE_REDIS_CACHE) {
            strategyConfig.setSuperServiceClass(BASE_PACKAGE + ".common.service.IBaseService");
            strategyConfig.setSuperServiceImplClass(BASE_PACKAGE + ".common.service.impl.BaseServiceImpl");
            strategyConfig.setSuperMapperClass(BASE_PACKAGE + ".common.expand.MyBaseMapper");
        }
        return strategyConfig;
    }

    private DataSourceConfig getDataSourceConfig() {

        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(DB_URL)
                .setUsername(DB_USERNAME)
                .setPassword(DB_PASSWORD)
                .setDriverName("com.mysql.jdbc.Driver")
                .setTypeConvert(new CustomMySqlTypeConvert());
        return dataSourceConfig;
    }

//    private PackageConfig getPackageConfig() {
//        return new PackageConfig().setParent(BASE_PACKAGE)
//                .setController("modules." + MODULE_NAME + ".controller")
//                .setEntity("modules." + MODULE_NAME + ".entity")
//                .setMapper("modules." + MODULE_NAME + ".mapper")
//                .setService("modules." + MODULE_NAME + ".service")
//                .setServiceImpl("modules." + MODULE_NAME + ".service.impl")
//                .setXml("modules." + MODULE_NAME + ".mapper.xml");
//    }

    private PackageConfig getPackageConfig() {
        return new PackageConfig().setParent(BASE_PACKAGE)
                .setController(MODULE_NAME + ".controller")
                .setEntity(MODULE_NAME + ".entity")
                .setMapper(MODULE_NAME + ".mapper")
                .setService(MODULE_NAME + ".service")
                .setServiceImpl(MODULE_NAME + ".service.impl")
                .setXml(MODULE_NAME + ".mapper.xml");
    }

    class CustomMySqlTypeConvert implements ITypeConvert {

        @Override
        public DbColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
            String t = fieldType.toLowerCase();
            if (t.contains("char") || t.contains("text")) {
                return DbColumnType.STRING;
            } else if (t.contains("bigint")) {
                return DbColumnType.LONG;
            } else if (t.contains("tinyint(1)")) {
                return DbColumnType.BOOLEAN;
            } else if (t.contains("tinyint(4)")) {
                return DbColumnType.BYTE;
            } else if (t.contains("int")) {
                return DbColumnType.INTEGER;
            } else if (t.contains("text")) {
                return DbColumnType.STRING;
            } else if (t.contains("bit")) {
                return DbColumnType.BOOLEAN;
            } else if (t.contains("decimal")) {
                return DbColumnType.BIG_DECIMAL;
            } else if (t.contains("clob")) {
                return DbColumnType.CLOB;
            } else if (t.contains("blob")) {
                return DbColumnType.BLOB;
            } else if (t.contains("binary")) {
                return DbColumnType.BYTE_ARRAY;
            } else if (t.contains("float")) {
                return DbColumnType.FLOAT;
            } else if (t.contains("double")) {
                return DbColumnType.DOUBLE;
            } else if (t.contains("json") || t.contains("enum")) {
                return DbColumnType.STRING;
            } else if (t.contains("date") || t.contains("time") || t.contains("year")) {
                switch (globalConfig.getDateType()) {
                    case ONLY_DATE:
                        return DbColumnType.DATE;
                    case SQL_PACK:
                        switch (t) {
                            case "date":
                                return DbColumnType.DATE_SQL;
                            case "time":
                                return DbColumnType.TIME;
                            case "year"://todo 这个year可能有bug
                                return DbColumnType.DATE_SQL;
                            default:
                                return DbColumnType.TIMESTAMP;
                        }
                    case TIME_PACK:
                        switch (t) {
                            case "date":
                                return DbColumnType.LOCAL_DATE;
                            case "time":
                                return DbColumnType.LOCAL_TIME;
                            case "year":
                                return DbColumnType.YEAR;
                            default:
                                return DbColumnType.LOCAL_DATE_TIME;
                        }
                }
            }
            return DbColumnType.STRING;
        }
    }
}
