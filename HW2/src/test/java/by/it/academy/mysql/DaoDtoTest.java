package by.it.academy.mysql;

import by.it.academy.mysql.dao.DaoDtoFactory;
import by.it.academy.mysql.dao.Expense;
import by.it.academy.mysql.dao.Receiver;
import by.it.academy.mysql.dao.mysql.DaoDto;
import by.it.academy.mysql.dao.mysql.MySqlClassConnection;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.mysql.MySqlConnection;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertNull;

public class DaoDtoTest {

    private DaoDto daoDto;
    private IDatabaseConnection connection;

    @Before
    public void setUp() throws Exception {
        try {
            daoDto = DaoDtoFactory.getDaoDto("mydb_test");
            connection = new MySqlConnection(MySqlClassConnection.getTestConnection(), "mydb_test");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() throws Exception {
        daoDto = null;
        connection.close();
    }

    @Test
    public void getReseiverNonExistentValueTest() throws DatabaseUnitException, SQLException {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(DaoDtoTest.class.getResourceAsStream("DaoDtoTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
        String id = "6";
        //When
        Receiver receiver = daoDto.getReceiver(Integer.parseInt(id));
        //Then
        assertNull(receiver);
        DatabaseOperation.DELETE.execute(connection, dataSet);
    }

    @Test
    public void getExpenseNonExistentValueTest() throws DatabaseUnitException, SQLException {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(DaoDtoTest.class.getResourceAsStream("DaoDtoTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
        String id = "6";
        //When
        Expense expense = daoDto.getExpense(Integer.parseInt(id));
        //Then
        assertNull(expense);
        DatabaseOperation.DELETE.execute(connection, dataSet);
    }


}
