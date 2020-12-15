/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.htcjsc.web.drama.db;

/**
 *
 * @author HTC-PC
 */
public class DbConfiguration {
    public static final String HOST_NAME = "localhost";
    public static final String DB_NAME = "drama";
    public static final String DB_PORT = "3307";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "acmalinh";
    public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final int DB_MIN_CONNECTIONS = 2;
    public static final int DB_MAX_CONNECTIONS = 4;
    // jdbc:mysql://hostname:port/dbname
    public static final String CONNECTION_URL = "jdbc:mysql://" + HOST_NAME + ":" + DB_PORT + "/" + DB_NAME;
     
    private DbConfiguration() {
        super();
    }
}
