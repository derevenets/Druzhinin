package ru.sapteh.Dao;

import java.util.List;

public interface Dao<Entity, Key> {
    void create(Entity entity);
    Entity read(Key key);
    List<Entity> readAll();
    void update(Entity entity);
    void delete (Entity entity);
}
