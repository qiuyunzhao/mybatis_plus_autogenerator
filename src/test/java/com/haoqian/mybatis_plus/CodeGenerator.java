package com.haoqian.mybatis_plus;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;

import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class CodeGenerator {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    /**
     * 代码生成器启动函数
     * <p>
     * 可配置项见官网：https://mybatis.plus/config/generator-config.html#mapper-2
     */
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        //1. 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir"); // 获取项目路径
        gc.setOutputDir(projectPath + "/src/main/java");     // 设置自动生成代码输出目录
        gc.setAuthor("haoqian");            // 作者
        gc.setOpen(false);                  // 生成后是否打开资源管理器
        // gc.setActiveRecord(true);        // 是否支持AR模式
        gc.setSwagger2(true);               // 实体属性 Swagger2 注解
        gc.setServiceName("%sService");     // 去除service接口的 I前缀
        gc.setFileOverride(true);           // 重新生成文件时是否覆盖
        gc.setIdType(IdType.ASSIGN_ID);     // 主键生成策略
        gc.setBaseResultMap(true);          // 生成基本结果集映射(xml)
        gc.setBaseColumnList(true);         // 基本查询字段列的sql片段(xml)
        gc.setDateType(DateType.TIME_PACK); // 实体类中日期类型
        mpg.setGlobalConfig(gc);

        //2. 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setUrl("jdbc:mysql://192.168.0.150:3306/mybatis_plus?useUnicode=true&useSSL=false&characterEncoding=utf8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("aaaaaa");
        mpg.setDataSource(dsc);

        // 包配置（包会自动创建）
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(scanner("模块名"));
        pc.setParent("com.haoqian.mybatis_plus");
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setMapper("mapper");
        pc.setXml("mapper");    // xml映射文件路径
        mpg.setPackageInfo(pc);

        //3. 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel); //数据库表映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel); //数据库表字段映射到实体的命名策略
        strategy.setEntityLombokModel(true);    // 实体是否为lombok模型（默认false）
        strategy.setRestControllerStyle(true);  // restful api风格控制器
        strategy.setControllerMappingHyphenStyle(true); // url中驼峰转连字符
        strategy.setInclude(scanner("表名，多个用英文逗号分割").split(",")); //逆向工程映射的表
        strategy.setTablePrefix(scanner("表名前缀"));// 表名前缀(生成的类名会去除该前缀)
        strategy.setVersionFieldName("version");     // 乐观锁名称
        strategy.setLogicDeleteFieldName("deleted"); // 逻辑删除字段名
        // 自动填充字段
        TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);
        TableFill gmtModified = new TableFill("gmt_modified", FieldFill.INSERT);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmtCreate);
        tableFills.add(gmtModified);
        strategy.setTableFillList(tableFills);

        mpg.setStrategy(strategy);

        // 模板引擎（如果选择非默认引擎，需要设置模板引擎）
        // mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        // mpg.setTemplateEngine(new VelocityTemplateEngine());  // 默认无需设置

        mpg.execute();
    }

}