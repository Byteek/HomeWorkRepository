package by.it.academy.loader;

import by.it.academy.dtos.EmployeeDto;
import by.it.academy.dtos.PersonDto;
import by.it.academy.pojos.Employee;
import by.it.academy.pojos.EmployeeDetail;
import by.it.academy.pojos.Person;

import java.util.function.Supplier;
import java.util.logging.Logger;


public class PersonLoader {
    public static void main(String[] args) throws Exception {

        Logger logger = (Logger.getLogger(PersonLoader.class.getName()));

        Employee employee = new Employee();
        {
            employee.setFirstName("Nikita");
            employee.setLastName("Pohodski");
            employee.setPhone("375333518629");

        }
        EmployeeDetail employeeDetail = new EmployeeDetail();
        {
            employeeDetail.setCountry("Belarus");
            employeeDetail.setState("Minsk");
            employeeDetail.setCity("Minsk");
            employeeDetail.setStreet("Garuna");
        }
        employee.setEmployeeDetail(employeeDetail);
        employeeDetail.setEmployee(employee);
        logger.info(Employee.class.getName());

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.create(employee);

        Person person = new Person(null,44,"Ni", "KI");
        PersonDto personDto = new PersonDto();
        personDto.create(person);

    }
}
