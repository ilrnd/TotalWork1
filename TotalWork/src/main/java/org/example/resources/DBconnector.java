package org.example.resources;

import java.sql.*;

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
            throw new RuntimeException(e);
        }
    }





}
