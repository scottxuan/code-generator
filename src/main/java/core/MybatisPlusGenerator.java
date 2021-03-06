package core;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.IOException;

import java.util.ResourceBundle;

/**
 * <p>
 * 代码生成器
 * </p>
 */
public class MybatisPlusGenerator {

    public static void main(String[] args) throws IOException {

        //用来获取Mybatis-Plus.properties文件的配置信息
        final ResourceBundle rb = ResourceBundle.getBundle("mybatis-plus");

        // 代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        String path = MybatisPlusGenerator.class.getResource("/" ).getPath();
        String ouPutDir = path.replace("/target/classes", "/src/main/java" );
        globalConfig.setOutputDir(ouPutDir);
        globalConfig.setFileOverride(true);
        globalConfig.setOpen(false);
        globalConfig.setEnableCache(false);
        globalConfig.setAuthor(rb.getString("author"));
        globalConfig.setKotlin(false);
        globalConfig.setSwagger2(true);
        globalConfig.setBaseResultMap(true);
        globalConfig.setBaseColumnList(true);
        globalConfig.setMapperName("%sMapper");
        globalConfig.setXmlName("%sMapper");
        globalConfig.setServiceName("%sService");
        globalConfig.setServiceImplName("%sServiceImpl");
        globalConfig.setControllerName("%sController");
        globalConfig.setEntityName("%s");
        autoGenerator.setGlobalConfig(globalConfig);

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setUrl(rb.getString("url"));
        dataSourceConfig.setDriverName(rb.getString("driver.name"));
        dataSourceConfig.setUsername(rb.getString("userName"));
        dataSourceConfig.setPassword(rb.getString("password"));
        autoGenerator.setDataSource(dataSourceConfig);

        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(rb.getString("package"));
        packageConfig.setController("controller");
        packageConfig.setService("service");
        packageConfig.setServiceImpl("service.impl");
        packageConfig.setEntity("entity");
        packageConfig.setMapper("mapper");
        autoGenerator.setPackageInfo(packageConfig);

        //自定义模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setController("/templates-my/controller.java.vm");
        templateConfig.setService("/templates-my/service.java.vm");
        templateConfig.setServiceImpl("/templates-my/serviceImpl.java.vm");
        templateConfig.setEntity("/templates-my/entity.java.vm");
        templateConfig.setMapper("/templates-my/mapper.java.vm");
        templateConfig.setXml("/templates-my/mapper.xml.vm");
        autoGenerator.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperControllerClass(rb.getString("base.controller"));
        strategy.setSuperEntityClass(rb.getString("base.entity"));
        strategy.setSuperMapperClass(rb.getString("base.mapper"));
        strategy.setSuperServiceClass(rb.getString("base.service"));
        strategy.setSuperServiceImplClass(rb.getString("base.service.impl"));
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        if (rb.containsKey("tableName")) {
            String[] tableNames = rb.getString("tableName" ).split("," );
            strategy.setInclude(tableNames);
        }
        strategy.setControllerMappingHyphenStyle(true);
        if (rb.containsKey("prefix")) {
            String[] prefixes = rb.getString("prefix" ).split("," );
            strategy.setTablePrefix(prefixes);
            strategy.setEntityBooleanColumnRemoveIsPrefix(true);
        }
        autoGenerator.setStrategy(strategy);
        autoGenerator.execute();
    }
}