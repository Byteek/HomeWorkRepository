package by.it.academy.dtos;

import by.it.academy.pojos.Person;
import by.it.academy.util.HibernateUtil;
import org.hibernate.Session;

public class PersonDto implements ModelDao<Person, String> {


    @Override
    public String create(Person person) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        return person.getId();
    }

    @Override
    public Person readGet(String id) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Person readPerson = session.get(Person.class, id);
        session.getTransaction().commit();
        return readPerson;
    }

    @Override
    public Person readLoad(String id) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Person readPerson = session.load(Person.class, id);
        session.getTransaction().commit();
        return readPerson;
    }

    @Override
    public void update(String id, Person person) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Person loadPerson = session.load(Person.class, id);
        loadPerson.setName(person.getName());
        loadPerson.setSurname(person.getSurname());
        loadPerson.setAge(person.getAge());
        session.getTransaction().commit();

    }

    @Override
    public boolean delete(String id) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Person personForDelete = session.get(Person.class, id);
        session.delete(personForDelete);
        session.getTransaction().commit();
        return true;
    }
}
