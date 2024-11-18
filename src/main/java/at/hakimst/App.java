package at.hakimst;

import java.sql.*;

public class App {
    public static void main(String[] args) {
        selectAll();

    }
    public static  void selectAll(){
        System.out.println("Select mit JDBC");

        String connectionUrl = "jdbc:mysql://127.0.0.1:3306/jdbc_aa2";
        String user = "root";
        String pwd = "";

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, pwd);)
        {
            System.out.println("Verbindung zur DB hergestellt!");
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM hobbies");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String mitschueler = rs.getString("mitschueler");
                String hobby = rs.getString("hobby");
                System.out.println("Student aus der DB; [ID] " + id + " [NAME] " + mitschueler + " [HOBBY] " + hobby);
            }
        } catch (SQLException e)
        {
            System.out.println("Fehler beim Aufbau der Verbindung zur DB: " + e.getMessage());
        }

    }
}
