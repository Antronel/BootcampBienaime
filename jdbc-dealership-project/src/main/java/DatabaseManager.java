<<<<<<< HEAD
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseManager {
    public static Connection getConnection() {
    }

    public class DatabaseManager {
    private static BasicDataSource dataSource;

    static {
        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/cardealership");
        dataSource.setUsername("your_db_username");
        dataSource.setPassword("your_db_password");
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}

}
=======
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseManager {
    public static Connection getConnection() {
    }

    public class DatabaseManager {
    private static BasicDataSource dataSource;

    static {
        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/cardealership");
        dataSource.setUsername("your_db_username");
        dataSource.setPassword("your_db_password");
    }

        public static Connection getConnection() throws SQLException {
            return null;
        }
}

}
>>>>>>> b4c7cd8 (Add jdbc-dealership-project files)
