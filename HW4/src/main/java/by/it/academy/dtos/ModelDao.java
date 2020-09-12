package by.it.academy.dtos;

import by.it.academy.pojos.Person;

public interface ModelDao<T  , IdType> {
    IdType create(T t);

    T readGet(IdType id);

    T readLoad(IdType id);

    void update(IdType id, T t);

    boolean delete(IdType id);
}
