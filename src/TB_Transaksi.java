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
public class TB_Transaksi {
      private final String URL = "jdbc:mysql://localhost:3306/db_penginapan";
    private final String USER = "root";
    private final String PASS = ""; //default string kosong
    
    Connection getConnection()  throws SQLException {
       return DriverManager.getConnection(URL, USER, PASS );            
    }
    
    public List<Transaksi> getAllTransaksi() throws SQLException {
        List<Transaksi> list_transaksi = new ArrayList();
        
        String sql = "select * from tb_transaksi";
        try (
                Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ) {
            while(rs.next()) {
                Transaksi transaksi = new Transaksi(
                        rs.getInt("id"), 
                        rs.getInt("pembeli_id"),
                        rs.getInt("admin_id"),
                        rs.getString("tgl_transaksi"),
                        rs.getString("total")
                );
                
                list_transaksi.add(transaksi);
            }
        }
        
        return list_transaksi;
    }
    
    public void InsertTransaksi(Transaksi p_transaksi) throws SQLException {
        String sql = "insert into tb_transaksi (pembeli_id, admin_id, tgl_transaksi, total) VALUES (?, ?, ?, ?)";
    
        try (
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setInt(1, p_transaksi.getPembeliId());
            stmt.setInt(2, p_transaksi.getAdminId());
            stmt.setString(3, p_transaksi.getTglTransaksi());
            stmt.setString(4, p_transaksi.getTotal());
            
            stmt.executeUpdate();
        }
    }
    
    public void updateTransaksi(Transaksi p_transaksi) throws SQLException {
    String sql = "UPDATE tb_transaksi SET pembeli_id = ?, admin_id = ?, tgl_transaksi = ?, total = ? WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            // Set parameter sesuai urutan kolom
            stmt.setInt(1, p_transaksi.getPembeliId());  
            stmt.setInt(2, p_transaksi.getAdminId());
            stmt.setString(3, p_transaksi.getTglTransaksi());       
            stmt.setString(4, p_transaksi.getTotal());
            stmt.setInt(5, p_transaksi.getId()); 

            // Eksekusi update
            stmt.executeUpdate();
        }
    }
    
    public void deleteTransaksi(int id) throws SQLException {
        String sql = "DELETE FROM tb_transaksi WHERE id = ?";

        try (Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);

            stmt.executeUpdate();
        }
    }
}
