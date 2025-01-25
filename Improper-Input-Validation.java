import java.sql.*;

public class SingleFunctionVulnerability {
    public void executeQuery(String userInput) {
        String query = "SELECT * FROM users WHERE username = '" + userInput + "'";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "password");
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println("User found: " + rs.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SingleFunctionVulnerability obj = new SingleFunctionVulnerability();
        obj.executeQuery("admin' OR '1'='1"); // SQL Injection attempt
    }
}
