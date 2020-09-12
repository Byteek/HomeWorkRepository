package by.it.academy.dtos;

import by.it.academy.pojos.Employee;
import by.it.academy.util.HibernateUtil;
import org.hibernate.Session;

public class EmployeeDto implements ModelDao<Employee, Long> {

    @Override
    public Long create(Employee employee) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        return employee.getId();
    }

    @Override
    public Employee readGet(Long id) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Employee readEmployee = session.get(Employee.class, id);
        session.getTransaction().commit();
        return readEmployee;
    }

    @Override
    public Employee readLoad(Long id) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Employee readEmployee = session.load(Employee.class, id);
        session.getTransaction().commit();
        return readEmployee;
    }

    @Override
    public void update(Long id, Employee employee) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
//        Employee loadEmployee = session.load(Employee.class, id);
        session.update(employee);
        session.getTransaction().commit();
    }

    @Override
    public boolean delete(Long id) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Employee employeeForDelete = session.get(Employee.class, id);
        session.delete(employeeForDelete);
        session.getTransaction().commit();
        return true;
    }
}

