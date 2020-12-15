/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.htcjsc.web.drama.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Component;
import vn.htcjsc.web.drama.config.MyContext;

/**
 *
 * @author HTC-PC
 */
@Component
public class HikariCPDataSource {
    
    private static final HikariConfig config = new HikariConfig();
 
    private static HikariDataSource ds;
 
    static {
        config.setDriverClassName(MyContext.DB_DRIVER);
        config.setJdbcUrl(MyContext.MYSQL_CONNECTION_URL);
        config.setUsername(MyContext.USER_NAME);
        config.setPassword(MyContext.PASSWORD);
        config.setMinimumIdle(MyContext.DB_MIN_CONNECTIONS);
        config.setMaximumPoolSize(MyContext.DB_MAX_CONNECTIONS);
        
        config.setMaximumPoolSize(MyContext.POOL_MAX_SIZE);
        config.setConnectionTestQuery(MyContext.CONNECTION_TEST_QUERY);
        config.setPoolName(MyContext.POOL_NAME);

        // Some additional properties
        config.addDataSourceProperty("cachePrepStmts", MyContext.CACHE_PREP_STMTS);
        config.addDataSourceProperty("prepStmtCacheSize", MyContext.PREP_STMT_CACHE_SIZE);
        config.addDataSourceProperty("prepStmtCacheSqlLimit", MyContext.PREP_STMT_CACHE_SQL_LIMIT);
        config.addDataSourceProperty("dataSource.useServerPrepStmts", MyContext.DATA_SOURCE_USE_SERVER_PREP_STMTS);
        
        ds = new HikariDataSource(config);
    }
 
    private HikariCPDataSource() {
        super();
    }
 
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static void freeConn(ResultSet rs, PreparedStatement pstm, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void freeConn(PreparedStatement pstm, Connection conn) {
        try {
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
