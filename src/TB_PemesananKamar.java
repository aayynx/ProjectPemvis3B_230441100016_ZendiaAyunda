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
public class TB_PemesananKamar {
    private final String URL = "jdbc:mysql://localhost:3306/db_penginapan";
    private final String USER = "root";
    private final String PASS = ""; //default string kosong
    
    Connection getConnection()  throws SQLException {
       return DriverManager.getConnection(URL, USER, PASS );            
    }
    
    public List<PesanKamar> getAllPesanan() throws SQLException {
        List<PesanKamar> list_pesanan = new ArrayList();
        
        String sql = "select * from tb_pesankamar";
        try (
                Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ) {
            while(rs.next()) {
                PesanKamar pesanan = new PesanKamar(
                        rs.getInt("id"), 
                        rs.getInt("jumlah_orang"),
                        rs.getString("total"),
                        rs.getString("tipe_kamar"),
                        rs.getString("nama_pembeli"),
                        rs.getString("tgl_checkin"),
                        rs.getString("tgl_checkout"),
                        rs.getString("membership"),
                        rs.getString("opsi_pembayaran"),
                        rs.getString("nomor_hp")
                );
                
                list_pesanan.add(pesanan);
            }
        }
        
        return list_pesanan;
    }
    
    public void InsertPesanan(PesanKamar p_pesanan) throws SQLException {
        String sql = "insert into tb_pesankamar (id, nomor_hp, jumlah_orang, total, tipe_kamar, nama_pembeli, tgl_checkin, tgl_checkout, membership, opsi_pembayaran) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
        try (
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setInt(1, p_pesanan.getId());
            stmt.setString(2, p_pesanan.getNomorHp());
            stmt.setInt(3, p_pesanan.getJumlahOrang());
            stmt.setString(4, p_pesanan.getTotal());
            stmt.setString(5, p_pesanan.getTipeKamar());
            stmt.setString(6, p_pesanan.getNamaPembeli());
            stmt.setString(7, p_pesanan.getTglCheckin());
            stmt.setString(8, p_pesanan.getTglCheckout());
            stmt.setString(9, p_pesanan.getMembership());
            stmt.setString(10, p_pesanan.getOpsiPembayaran());
            
            stmt.executeUpdate();
        }
    }
    
    public void updatePesanan(PesanKamar p_pesanan) throws SQLException {
    String sql = "UPDATE tb_pesankamar SET nomor_hp = ?, jumlah_orang = ?, total = ?, tipe_kamar = ?, nama_pembeli = ?, tgl_checkin = ?, tgl_checkout = ?, membership = ?, opsi_pembayaran = ? WHERE nama_pembeli = ?";
    
    try (Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, p_pesanan.getNomorHp());
        stmt.setInt(2, p_pesanan.getJumlahOrang());
        stmt.setString(3, p_pesanan.getTotal());
        stmt.setString(4, p_pesanan.getTipeKamar());
        stmt.setString(5, p_pesanan.getNamaPembeli());
        stmt.setString(6, p_pesanan.getTglCheckin());
        stmt.setString(7, p_pesanan.getTglCheckout());
        stmt.setString(8, p_pesanan.getMembership());
        stmt.setString(9, p_pesanan.getOpsiPembayaran());
        stmt.setString(10, p_pesanan.getNamaPembeli());
        
        stmt.executeUpdate();
        }
    }
    
    public void deletePesanan(String namaPembeli) throws SQLException {
    String sql = "DELETE FROM tb_pesankamar WHERE nama_pembeli = ?";

    try (Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, namaPembeli);
        
        stmt.executeUpdate();
        }
    }
    
    public static PesanKamar getPesanan(String nama) throws SQLException {
        String query = "SELECT * FROM tb_pesankamar WHERE nama_pembeli = ?"; 
        try (Connection connection = new TB_PemesananKamar().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
             
            stmt.setString(1, nama);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new PesanKamar(
                    rs.getInt("id"),
                    rs.getInt("jumlah_orang"),
                    rs.getString("total"),
                    rs.getString("nomor_hp"),
                    rs.getString("tipe_kamar"),
                    rs.getString("nama_pembeli"),
                    rs.getString("tgl_checkin"),
                    rs.getString("tgl_checkout"),
                    rs.getString("membership"),
                    rs.getString("opsi_pembayaran")
                );
            }
        }
        return null; 
    }
}
