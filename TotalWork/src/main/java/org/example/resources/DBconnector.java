package org.example.resources;

import com.mysql.cj.result.BufferedRowList;

import java.sql.*;
import java.time.LocalDate;

public class DBconnector {
    private static final String url = "jdbc:mysql://urtec.beget.tech";
    private static final String user = "urtec_test_db";
    private static final String password = "Test_123";
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public void connection(){
        String query =
                "SELECT * FROM urtec_test_db.animals;";
        try{
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                System.out.println("ID " + id + "name " + name);
            }
        } catch (SQLException e) {
            System.out.println("Error SQL connection");;
        }
    }

    public void addSQL(String name, String type, String dateOfBirth, String commands){
        String query =
                "INSERT INTO urtec_test_db.animals " +
                        "(name, type, date_of_birth, commands) " +
                        "VALUES (" +  name + "," + type + "," + dateOfBirth + "," + commands + ");";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, user, password)){
                Statement statement = conn.createStatement();
                int rows = statement.executeUpdate(query);
                System.out.printf("Added %d rows\n", rows);
            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }
    }

