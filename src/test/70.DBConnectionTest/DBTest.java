import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Connect to the database
            String url = "jdbc:mysql://localhost/mydatabase";
            String user = "root";
            String password = "";
            connection = DriverManager.getConnection(url, user, password);

            // Create a statement
            statement = connection.createStatement();

            // Create the table
            String createTableQuery = "CREATE TABLE customers (name VARCHAR(255), address VARCHAR(255))";
            statement.executeUpdate(createTableQuery);

            // Insert a record
            String insertQuery = "INSERT INTO customers (name, address) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, "John");
            preparedStatement.setString(2, "Highway 21");
            preparedStatement.executeUpdate();

            // Commit the transaction
            connection.commit();

            System.out.println(preparedStatement.getUpdateCount() + " record inserted.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close statement and connection
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
