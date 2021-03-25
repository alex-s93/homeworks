package com.alevel.homework26.dao;

import com.alevel.homework26.model.User;
import org.bson.types.ObjectId;

import java.util.List;

public interface Dao<T> {
    T get(ObjectId id);

    List<T> findAll();

    void delete(ObjectId id);

    void save(User user);
}
