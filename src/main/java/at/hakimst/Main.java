package at.hakimst;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        //INSERT INTO `student` (`id`, `name`, `email`) VALUES (NULL, 'Alexander Klapeer', 'alklapeer@tsn.at'), (NULL, 'maria könne', 'maria.koenne@myimst.at');
        selectAllDemo();
        insertStudentDemo("Name des Studenten", "Email@prov.at");
        updateStudentDemo(4, "Neuer Name", "neueemail@provider.at");
        deletStudentDemo(5);
        selectAllDemo();
        findAllByNameLike("and");


//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            try {
//                Connection com = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
//            }catch(SQLException e) {
//                throw new RuntimeException("Die Verbindung nicht möglich");
//            }
//        }
//        catch(ClassNotFoundException e){
//            throw new RuntimeException("Treiber nicht gefunden!");
//        }


    }

    private static void findAllByNameLike(String pattern) {
        System.out.println("Find all by Name DEMO mit JDBC");

        String connectionUrl = "jdbc:mysql://127.0.0.1:3306/jdbcdemo";
        String user = "root";
        String pwd = "";

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, pwd);)
        {
            System.out.println("Verbindung zur DB hergestellt!");
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT * FROM student WHERE student.name LIKE ?"
            );
            preparedStatement.setString(1, "%" + pattern + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.println("Student aus der DB; [ID] " + id + " [NAME] " + name + " [EMAIL] " + email);
            }
        } catch (SQLException e)
        {
            System.out.println("Fehler beim Aufbau der Verbindung zur DB: " + e.getMessage());
        }
    }


    public static void deletStudentDemo(int studentId){
        System.out.println("DELETE DEMO mit JDBC");

        String connectionUrl = "jdbc:mysql://127.0.0.1:3306/jdbcdemo";
        String user = "root";
        String pwd = "";

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, pwd);)
        {
            System.out.println("Verbindung zur DB hergestellt!");
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "DELETE FROM student WHERE student.id = ?"
            );
            try
            {
                preparedStatement.setInt(1, studentId);
                int rowAffected = preparedStatement.executeUpdate();
                System.out.println("Anzahl der gelöschten Datensätze: " + rowAffected);
            } catch (SQLException ex)
            {
                System.out.println("Fehler im SQL-DELETE Statement: " + ex.getMessage());
            }

        } catch (SQLException e)
        {
            System.out.println("Fehler beim Aufbau der Verbindung zur DB: " + e.getMessage());
        }
    }

    public static void updateStudentDemo(int id, String neuerName, String neueEmail) {
        System.out.println("Update DEMO mit JDBC");

        String connectionUrl = "jdbc:mysql://127.0.0.1:3306/jdbcdemo";
        String user = "root";
        String pwd = "";

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, pwd);)
        {
            System.out.println("Verbindung zur DB hergestellt!");
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "UPDATE student SET name = ?, email = ? WHERE student.id = ?"
            );
            try
            {
                preparedStatement.setString(1, neuerName);
                preparedStatement.setString(2, neueEmail);
                preparedStatement.setInt(3, id);
                int affectedRows = preparedStatement.executeUpdate();
                System.out.println("Anzahl der aktualisierten Datensätze: " + affectedRows);
            } catch (SQLException ex)
            {
                System.out.println("Fehler im SQL-UPDATE Statement: " + ex.getMessage());
            }

        } catch (SQLException e)
        {
            System.out.println("Fehler beim Aufbau der Verbindung zur DB: " + e.getMessage());
        }
    }

    public static void insertStudentDemo(String name, String email){
        System.out.println("Insert DEMO mit JDBC");

        String connectionUrl = "jdbc:mysql://127.0.0.1:3306/jdbcdemo";
        String user = "root";
        String pwd = "";

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, pwd);)
        {
            System.out.println("Verbindung zur DB hergestellt!");
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "INSERT INTO `student` (`id`, `name`, `email`) VALUES (NULL, ?, ?)"
            );
            try
            {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, email);
                int rowAffected = preparedStatement.executeUpdate();
                System.out.println(rowAffected + "Datensätze eingefügt");
            } catch (SQLException ex)
            {
                System.out.println("Fehler im SQL-INSERT Statement: " + ex.getMessage());
            }

        } catch (SQLException e)
        {
            System.out.println("Fehler beim Aufbau der Verbindung zur DB: " + e.getMessage());
        }
    }

    public static  void selectAllDemo(){
        System.out.println("Select DEMO mit JDBC");

        String connectionUrl = "jdbc:mysql://127.0.0.1:3306/jdbcdemo";
        String user = "root";
        String pwd = "";

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, pwd);)
        {
            System.out.println("Verbindung zur DB hergestellt!");
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM student");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.println("Student aus der DB; [ID] " + id + " [NAME] " + name + " [EMAIL] " + email);
            }
        } catch (SQLException e)
        {
            System.out.println("Fehler beim Aufbau der Verbindung zur DB: " + e.getMessage());
        }

    }
}