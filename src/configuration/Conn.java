
package configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
    
    private final String URL = "jdbc:mysql://localhost:3306/is_library";
    private final String USERNAME = "root";
    private final String PASSWORD = "Ryanny1003";
    
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
