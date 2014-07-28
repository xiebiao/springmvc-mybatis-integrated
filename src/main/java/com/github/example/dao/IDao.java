package com.github.example.dao;

/**
 * @author xiebiao
 */
public interface IDao {

    <T> java.lang.Integer insert(T t) throws org.springframework.dao.DataAccessException;

    java.lang.Integer delete(java.lang.String key) throws org.springframework.dao.DataAccessException;

    <T> java.lang.Integer update(T t) throws org.springframework.dao.DataAccessException;

    <T> T find(java.lang.String key) throws org.springframework.dao.DataAccessException;

    <E> java.util.List<E> listForObject(E e) throws org.springframework.dao.DataAccessException;

    <E> java.lang.Integer countForObject(E e) throws org.springframework.dao.DataAccessException;
}
