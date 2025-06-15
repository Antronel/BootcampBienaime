import java.sql.Connection;

public class SalesContractDao {void saveSalesContract(org.example.SalesContract contract);
}
try (
Connection conn = DatabaseManager.getConnection()) {