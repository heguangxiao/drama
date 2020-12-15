/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.htcjsc.web.drama.dao;

import java.util.List;

/**
 *
 * @author HTC-PC
 * @param <T>
 */
public interface BaseDao<T> {
    List<T> findAll();
    T findById(long id);
    boolean add(T t);
    boolean update(T t);
    boolean deleteById(long id);
}
