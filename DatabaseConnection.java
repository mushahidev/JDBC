package Task81624;

import java.sql.*;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/employees";
    private static final String USER = "root";
    private static final String PASSWORD = "mdevmysql";

    public void addUser(UserData userData) {
        String sql = "INSERT INTO userinfo(userName, firstName, lastName, city) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, userData.getUserName());
            pstmt.setString(2, userData.getFirstName());
            pstmt.setString(3, userData.getLastName());
            pstmt.setString(4, userData.getCity());

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("User added Successfully");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(UserData userData) {
        String sql = "UPDATE userinfo SET userName = ?, firstName = ?, lastName = ?, city = ? WHERE userId = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, userData.getUserName());
            pstmt.setString(2, userData.getFirstName());
            pstmt.setString(3, userData.getLastName());
            pstmt.setString(4, userData.getCity());

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("User updated Successfully");
            } else {
                System.out.println("User not found");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUser(int userId) {
        String sql = "DELETE FROM userinfo WHERE userId = ?";

        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, userId);

            int rowsDeleted = pstmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("User removed Successfully");
            } else {
                System.out.println("User not found");
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void displayUser() {
        String sql = "SELECT * FROM userinfo";

        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String userName = rs.getString("userName");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String city = rs.getString("city");

                System.out.println("User Name: " + userName);
                System.out.println("First Name: " + firstName);
                System.out.println("Last Name: " + lastName);
                System.out.println("City: " + city);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
