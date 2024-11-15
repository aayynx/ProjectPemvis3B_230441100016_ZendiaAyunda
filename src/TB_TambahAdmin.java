
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sindy
 */
public class TB_TambahAdmin {
    private final String URL = "jdbc:mysql://localhost:3306/db_penginapan";
    private final String USER = "root";
    private final String PASS = ""; //default string kosong
    
    Connection getConnection()  throws SQLException {
       return DriverManager.getConnection(URL, USER, PASS );            
    }
    
    public List<TambahAdmin> getAllAdmin() throws SQLException {
        List<TambahAdmin> list_admin = new ArrayList();
        
        String sql = "select * from tb_admin";
        try (
                Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ) {
            while(rs.next()) {
                TambahAdmin admin = new TambahAdmin(
                        rs.getInt("id"), 
                        rs.getString("nama_admin"),
                        rs.getString("role"),
                        rs.getString("tgl_bergabung")
                );
                
                list_admin.add(admin);
            }
        }
        
        return list_admin;
    }
    
    public void InsertAdmin(TambahAdmin p_admin) throws SQLException {
        String sql = "insert into tb_admin (nama_admin, role, tgl_bergabung) values (?, ?, ?)";
    
        try (
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setString(1, p_admin.getNamaAdmin());
            stmt.setString(2, p_admin.getRole());
            stmt.setString(3, p_admin.getTglBergabung());
            
            stmt.executeUpdate();
        }
    }
    
    public void updateAdmin(TambahAdmin p_admin) throws SQLException {
    String sql = "UPDATE tb_admin SET nama_admin = ?, role = ?, tgl_bergabung = ? WHERE id = ?";
    
    try (Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, p_admin.getNamaAdmin());
        stmt.setString(2, p_admin.getRole());
        stmt.setString(3, p_admin.getTglBergabung());
        stmt.setInt(4, p_admin.getId());
        
        stmt.executeUpdate();
        }
    }
    
    public void deleteAdmin(int id) throws SQLException {
        String sql = "DELETE FROM tb_admin WHERE id = ?";

        try (Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);

            stmt.executeUpdate();
        }
    }
}
