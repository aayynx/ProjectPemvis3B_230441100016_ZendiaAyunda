
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sindy
 */
public class TB_Registrasi {
    private final String URL = "jdbc:mysql://localhost:3306/db_penginapan";
    private final String USER = "root";
    private final String PASS = ""; //default string kosong
    
    Connection getConnection()  throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Register driver
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver MySQL JDBC tidak ditemukan.");
            ex.printStackTrace();
        }
       return DriverManager.getConnection(URL, USER, PASS );            
    }
    
//    public List<LogRegistrasi> getAllRegistrasi() throws SQLException {
//        List<LogRegistrasi> list_registrasi = new ArrayList();
//        
//        String sql = "select * from tb_registrasi";
//        try (
//                Connection conn = getConnection();
//                Statement stmt = conn.createStatement();
//                ResultSet rs = stmt.executeQuery(sql);
//        ) {
//            while(rs.next()) {
//                LogRegistrasi registrasi = new LogRegistrasi(
//                        rs.getInt("id"), 
//                        rs.getString("email"),
//                        rs.getString("username"),
//                        rs.getString("password")
//                );
//                
//                list_registrasi.add(registrasi);
//            }
//        }
//        
//        return list_registrasi;
//    } 
    
        public void InsertLogRegistrasi(LogRegistrasi p_logregistrasi) throws SQLException {
        String checkQuery = "SELECT COUNT(*) FROM tb_registrasi WHERE email = ? OR username = ? OR password = ?";
        String insertQuery = "INSERT INTO tb_registrasi (id, email, username, password) VALUES (?, ?, ?, ?)";

        try (
            Connection conn = getConnection();
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
        ) {
            // Cek apakah email, username, atau password sudah ada
            checkStmt.setString(1, p_logregistrasi.getEmail());
            checkStmt.setString(2, p_logregistrasi.getUsername());
            checkStmt.setString(3, p_logregistrasi.getPassword());

            ResultSet rs = checkStmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);

            if (count > 0) {
                JOptionPane.showMessageDialog(null, "Email, Username, atau Password sudah terdaftar.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return; 
            }

            // Menambahkan data jika tidak ada yang sama
            insertStmt.setInt(1, p_logregistrasi.getId());
            insertStmt.setString(2, p_logregistrasi.getEmail());
            insertStmt.setString(3, p_logregistrasi.getUsername());
            insertStmt.setString(4, p_logregistrasi.getPassword());

            int rowsAffected = insertStmt.executeUpdate();
        }
    }
}
