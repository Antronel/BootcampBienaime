<<<<<<< HEAD
package com.pluralsight.dealership;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseManager {
    private static BasicDataSource dataSource;

    static {
        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/car_dealership");
        dataSource.setUsername("root"); // Replace with your DB username
        dataSource.setPassword("password"); // Replace with your DB password
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxOpenPreparedStatements(100);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
=======
package com.pluralsight.dealership;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseManager {
    private static BasicDataSource dataSource;

    static {
        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/car_dealership");
        dataSource.setUsername("root"); // Replace with your DB username
        dataSource.setPassword("password"); // Replace with your DB password
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxOpenPreparedStatements(100);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
>>>>>>> b4c7cd8 (Add jdbc-dealership-project files)
