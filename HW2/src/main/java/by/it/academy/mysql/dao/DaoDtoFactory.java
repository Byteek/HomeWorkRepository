package by.it.academy.mysql.dao;

import by.it.academy.mysql.dao.mysql.DaoDto;

import java.security.InvalidParameterException;
import java.sql.SQLException;

public class DaoDtoFactory {
    private static DaoDto daoDto;

    public static DaoDto getDaoDto(String database) throws SQLException {
        if ("mydb".equals(database)) {
            if (daoDto == null) {
                daoDto = new DaoDto();
            }
            return daoDto;
        } else if ("mydb_test".equals(database)) {
            if (daoDto == null) {
                daoDto = new DaoDto();
            }
            return daoDto;
        }
        throw new InvalidParameterException("No such database implenemted " + database);
    }

}
