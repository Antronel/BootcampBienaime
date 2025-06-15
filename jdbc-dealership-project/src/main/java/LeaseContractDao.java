import java.sql.Connection;

public class LeaseContractDao {void saveLeaseContract(org.example.LeaseContract contract);
}
try (
Connection conn = DatabaseManager.getConnection()) {