/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
/**
 *
 * @author sindy
 */
public class TB_loginPembeli {
    
    private final String URL = "jdbc:mysql://localhost:3306/db_penginapan";
    private final String USER = "root";
    private final String PASS = ""; //default string kosong
    
    Connection getConnection()  throws SQLException {
       return DriverManager.getConnection(URL, USER, PASS );            
    }
    
    public boolean LogPembeli(String username, String password) throws SQLException {
    String sql = "SELECT * FROM tb_registrasi WHERE username = ? AND password = ?";

        try (
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setString(1, username);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        }
    }
}
