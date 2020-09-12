package by.it.academy.dtos;

import by.it.academy.pojos.Person;

public interface ModelEmployeeDao<T, IdType> {
    String create(T t);

    Person readGet(IdType id);

    Person readLoad(IdType id);

    void update(IdType id, T t);

    boolean delete(IdType id);
}
