package com.crystalgems.gemhunt.dao;

public abstract class DAO<T, R> {

    public abstract boolean create(T obj);

    public abstract boolean delete(T obj);

    public abstract boolean update(T obj);

    public abstract T find(R id);
}