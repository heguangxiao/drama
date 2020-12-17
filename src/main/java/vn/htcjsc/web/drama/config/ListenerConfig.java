/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.htcjsc.web.drama.config;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author HTC-PC
 */
@WebListener
public class ListenerConfig  implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {     
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        Driver driver = null;
        while (drivers.hasMoreElements()) {
            try {
                driver = drivers.nextElement();
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        AbandonedConnectionCleanupThread.checkedShutdown();
    } 
    
}
