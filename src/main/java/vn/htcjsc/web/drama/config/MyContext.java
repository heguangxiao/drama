/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.htcjsc.web.drama.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import vn.htcjsc.web.drama.interceptor.UrlLocaleResolver;

/**
 *
 * @author HTC-PC
 */
@Configuration
@ComponentScan("vn.htcjsc.web.drama.*") 
@PropertySource(value = {"classpath:application.properties"})
@EnableTransactionManagement
public class MyContext {
            
    public static String HOST_NAME = "localhost";
    public static String DB_NAME = "drama";
    public static String DB_PORT = "3307";
    public static String USER_NAME = "root";
    public static String PASSWORD = "";
    public static String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static int DB_MIN_CONNECTIONS = 2;
    public static int DB_MAX_CONNECTIONS = 4;
    // jdbc:mysql://hostname:port/dbname
    public static final String MYSQL_CONNECTION_URL = "jdbc:mysql://" + HOST_NAME + ":" + DB_PORT + "/" + DB_NAME;
    
    public static String POOL_NAME = "drama";
    public static String CONNECTION_TEST_QUERY = "SELECT 1";   
    public static int POOL_MAX_SIZE = 5;
    
    public static String CACHE_PREP_STMTS = "true";   
    public static String PREP_STMT_CACHE_SIZE = "250";   
    public static String PREP_STMT_CACHE_SQL_LIMIT = "2048";   
    public static String DATA_SOURCE_USE_SERVER_PREP_STMTS = "true";  
        
    @Autowired
    private Environment environment;
    
    @PostConstruct
    public void init() {
        try {
            HOST_NAME = getString("drama.db.host", HOST_NAME);
            DB_NAME = getString("drama.db.name", DB_NAME);
            DB_PORT = getString("drama.db.port", DB_PORT);
            USER_NAME = getString("drama.db.user", USER_NAME);
            PASSWORD = getString("drama.db.pass", PASSWORD);
            DB_DRIVER = getString("drama.db.driver", DB_DRIVER);
            DB_MIN_CONNECTIONS = getInt("drama.db.minConnections", DB_MIN_CONNECTIONS);
            DB_MAX_CONNECTIONS = getInt("drama.db.maxConnections", DB_MAX_CONNECTIONS);
            
            POOL_NAME = getString("drama.pool.name", POOL_NAME);
            CONNECTION_TEST_QUERY = getString("drama.pool.testQueryConnection", CONNECTION_TEST_QUERY);
            POOL_MAX_SIZE = getInt("drama.pool.maxSize", POOL_MAX_SIZE);
            
            CACHE_PREP_STMTS = getString("drama.db.property.cachePrepStmts", CACHE_PREP_STMTS);
            PREP_STMT_CACHE_SIZE = getString("drama.db.property.prepStmtCacheSize", PREP_STMT_CACHE_SIZE);
            PREP_STMT_CACHE_SQL_LIMIT = getString("drama.db.property.prepStmtCacheSqlLimit", PREP_STMT_CACHE_SQL_LIMIT);
            DATA_SOURCE_USE_SERVER_PREP_STMTS = getString("drama.db.property.dataSource.useServerPrepStmts", DATA_SOURCE_USE_SERVER_PREP_STMTS);
                                    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    @PreDestroy
    public void destroy() {
        System.out.println("Destroy!");
    }
        
//    @Bean(name = "viewResolver")
//    public InternalResourceViewResolver getViewResolver() {
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setPrefix("/WEB-INF/pages/");
//        viewResolver.setSuffix(".jsp");
//        return viewResolver;
//    }

    @Bean(name = "viewResolver")
    public ViewResolver getViewResolver() {
        UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
 
        // TilesView 3
        viewResolver.setViewClass(TilesView.class);
 
        return viewResolver;
    }
 
    @Bean(name = "tilesConfigurer")
    public TilesConfigurer getTilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
 
        // TilesView 3
        tilesConfigurer.setDefinitions("/tiles/tiles.xml");
 
        return tilesConfigurer;
    }
    
    @Bean(name = "messageSource")
    public MessageSource getMessageResource()  {
        ReloadableResourceBundleMessageSource messageResource= new ReloadableResourceBundleMessageSource();

        // Đọc vào file i18n/messages_xxx.properties
        // Ví dụ: i18n/message_en.properties
        messageResource.setBasename("classpath:i18n/messages");
        messageResource.setDefaultEncoding("UTF-8");
        return messageResource;
    }
    
    @Bean(name = "localeResolver")
    public LocaleResolver getLocaleResolver()  {
        LocaleResolver resolver= new UrlLocaleResolver();
//        CookieLocaleResolver resolver= new CookieLocaleResolver();
//        resolver.setCookieDomain("myLocaleCookie");
//        // 60 phút.
//        resolver.setCookieMaxAge(60*60);
        return resolver;
    }
    
    @Bean(name = "multipartResolver")
    public MultipartResolver getMultipartResolver() {
        CommonsMultipartResolver resover = new CommonsMultipartResolver();
        // 10MB
        resover.setMaxUploadSize(10 * 1024 * 1024); 
        return resover;
    } 
    
    int getInt(String properties, int defaultVal) {
        try {
            return Integer.parseInt(environment.getProperty(properties, defaultVal + ""));
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return defaultVal;
        }
    }

    long getLong(String properties, long defaultVal, String categoryName) {
        try {
            return Long.parseLong(environment.getProperty(properties, defaultVal + ""));
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return defaultVal;
        }
    }

    Double getDouble(String properties, Double defaultVal) {
        try {
            return Double.parseDouble(environment.getProperty(properties, defaultVal + ""));
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return defaultVal;
        }
    }

    String getString(String properties, String defaultVal) {
        try {
            return environment.getProperty(properties, defaultVal);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return defaultVal;
        }
    }

    boolean getBoolean(String properties, boolean defaultVal) {
        try {
            return environment.getProperty(properties, "0").equals("1") || environment.getProperty(properties, "false").equals("true");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return defaultVal;
        }
    }      
    
    @Bean(name = "dataSource")
    public HikariDataSource dataSource() {
        HikariConfig config = new HikariConfig();
        HikariDataSource ds;
        
        config.setDriverClassName(DB_DRIVER);
        config.setJdbcUrl(MYSQL_CONNECTION_URL);
        config.setUsername(USER_NAME);
        config.setPassword(PASSWORD);
        config.setMinimumIdle(DB_MIN_CONNECTIONS);
        config.setMaximumPoolSize(DB_MAX_CONNECTIONS);
        
        config.setMaximumPoolSize(POOL_MAX_SIZE);
        config.setConnectionTestQuery(CONNECTION_TEST_QUERY);
        config.setPoolName(POOL_NAME);

        // Some additional properties
        config.addDataSourceProperty("cachePrepStmts", CACHE_PREP_STMTS);
        config.addDataSourceProperty("prepStmtCacheSize", PREP_STMT_CACHE_SIZE);
        config.addDataSourceProperty("prepStmtCacheSqlLimit", PREP_STMT_CACHE_SQL_LIMIT);
        config.addDataSourceProperty("dataSource.useServerPrepStmts", DATA_SOURCE_USE_SERVER_PREP_STMTS);
        
        ds = new HikariDataSource(config);

        return ds;
    }
    
    @Autowired
    @Bean(name = "transactionManager")
    public DataSourceTransactionManager getTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);

        return transactionManager;
    }
}
