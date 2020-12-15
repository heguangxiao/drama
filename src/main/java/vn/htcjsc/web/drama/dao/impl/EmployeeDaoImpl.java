/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.htcjsc.web.drama.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import vn.htcjsc.web.drama.dao.EmployeeDao;
import vn.htcjsc.web.drama.db.HikariCPDataSource;
import vn.htcjsc.web.drama.model.Employee;

/**
 *
 * @author HTC-PC
 */
@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
    
    @Override
    public List<Employee> findAll() {        
        ArrayList<Employee> result = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT E.* FROM employees E WHERE 1 = 1 ";
        sql += " ORDER BY E.ID DESC";
        try {
            conn = HikariCPDataSource.getConnection();
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Employee t = new Employee();
                t.setId(rs.getLong("ID"));
                t.setCode(rs.getString("CODE"));
                t.setFullname(rs.getString("FULLNAME"));
                t.setUsername(rs.getString("USERNAME"));
                t.setPassword(rs.getString("PASSWORD"));
                t.setAddress(rs.getString("ADDRESS"));
                t.setEmail(rs.getString("EMAIL"));
                t.setPhone(rs.getString("PHONE"));
                t.setSex(rs.getInt("SEX"));
                t.setStatus(rs.getInt("STATUS"));
                result.add(t);
            }
        } catch (SQLException e) {
            System.out.println("EmployeeDaoImpl : findAll()");
            System.out.println(e.getMessage());
        } finally {
            HikariCPDataSource.freeConn(rs, pstm, conn);
        }
        return result;
    }

    @Override
    public Employee findById(long id) {
        Employee t = null;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT E.* FROM employees E WHERE E.ID = ? ";
        try {
            conn = HikariCPDataSource.getConnection();
            pstm = conn.prepareStatement(sql);
            int i = 1;
            pstm.setLong(i++, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                t = new Employee();
                t.setId(rs.getLong("ID"));
                t.setCode(rs.getString("CODE"));
                t.setFullname(rs.getString("FULLNAME"));
                t.setUsername(rs.getString("USERNAME"));
                t.setPassword(rs.getString("PASSWORD"));
                t.setAddress(rs.getString("ADDRESS"));
                t.setEmail(rs.getString("EMAIL"));
                t.setPhone(rs.getString("PHONE"));
                t.setSex(rs.getInt("SEX"));
                t.setStatus(rs.getInt("STATUS"));
            }
        } catch (SQLException e) {
            System.out.println("EmployeeDaoImpl : findById(long id)");
            System.out.println(e.getMessage());
        } finally {
            HikariCPDataSource.freeConn(rs, pstm, conn);
        }
        return t;
    }

    @Override
    public boolean add(Employee t) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "INSERT INTO employees( "
                + "CODE, "
                + "FULLNAME, "
                + "USERNAME, "
                + "PASSWORD, "
                + "ADDRESS, "
                + "EMAIL, "
                + "PHONE, "
                + "SEX, "
                + "STATUS) "
                + "VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?) ";        
        try {
            conn = HikariCPDataSource.getConnection();
            pstm = conn.prepareStatement(sql);
            int i = 1;
            pstm.setString(i++, t.getCode());
            pstm.setString(i++, t.getFullname());
            pstm.setString(i++, t.getUsername());
            pstm.setString(i++, t.getPassword());
            pstm.setString(i++, t.getAddress());
            pstm.setString(i++, t.getEmail());
            pstm.setString(i++, t.getPhone());
            pstm.setInt(i++, t.getSex());
            pstm.setInt(i++, t.getStatus());
            if (pstm.executeUpdate() == 1) {
                flag = true;
            } else {
                System.out.println("Don't add new employee");
            }
        } catch (SQLException e) {
            System.out.println("EmployeeDaoImpl : add(Employee t)");
            System.out.println(e.getMessage());
        } finally {
            HikariCPDataSource.freeConn(rs, pstm, conn);
        }
        return flag;
    }

    @Override
    public boolean update(Employee t) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "UPDATE employees SET "
                + "CODE = ?, "
                + "FULLNAME = ?, "
                + "USERNAME = ?, "
                + "ADDRESS = ?, "
                + "EMAIL = ?, "
                + "PHONE = ?, "
                + "SEX = ? "
                + "WHERE ID = ?";
        try {
            conn = HikariCPDataSource.getConnection();
            pstm = conn.prepareStatement(sql);
            int i = 1;
            pstm.setString(i++, t.getCode());
            pstm.setString(i++, t.getFullname());
            pstm.setString(i++, t.getUsername());
            pstm.setString(i++, t.getAddress());
            pstm.setString(i++, t.getEmail());
            pstm.setString(i++, t.getPhone());
            pstm.setInt(i++, t.getSex());
            pstm.setLong(i++, t.getId());
            if (pstm.executeUpdate() == 1) {
                flag = true;
            }
        } catch (SQLException e) {
            System.out.println("EmployeeDaoImpl : update(Employee t)");
            System.out.println(e.getMessage());
        } finally {
            HikariCPDataSource.freeConn(rs, pstm, conn);
        }
        return flag;
    }

    @Override
    public boolean deleteById(long id) {        
        boolean flag = false;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "DELETE FROM employees WHERE ID = ?";
        try {
            conn = HikariCPDataSource.getConnection();
            pstm = conn.prepareStatement(sql);
            int i = 1;
            pstm.setLong(i++, id);
            if (pstm.executeUpdate() == 1) {
                flag = true;
            }
        } catch (SQLException e) {
            System.out.println("EmployeeDaoImpl : deleteById(long id)");
            System.out.println(e.getMessage());
        } finally {
            HikariCPDataSource.freeConn(rs, pstm, conn);
        }
        return flag;
    }
    
}
