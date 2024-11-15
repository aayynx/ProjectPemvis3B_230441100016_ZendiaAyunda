/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sindy
 */
public class Transaksi {
    private int id, pembeli_id, admin_id;
    private String  tgl_transaksi, total;
    
    public Transaksi (int p_id, int p_pembeli_id, int p_admin_id, String p_tgl_transaksi, String p_total){
        this.id = p_id;
        this.pembeli_id = p_pembeli_id;
        this.admin_id = p_admin_id;
        this.tgl_transaksi = p_tgl_transaksi;
        this.total = p_total;
    }
    
    public void setId(int p_id) {
        this.id = p_id;
    }
    
    public int getId() {
        return id;
    }
    
    public void setPembeliId(int p_pembeli_id) {
        this.pembeli_id = p_pembeli_id;
    }
    
    public int getPembeliId() {
        return pembeli_id;
    }
    
    public void setAdminId(int p_admin_id) {
        this.admin_id = p_admin_id;
    }
    
    public int getAdminId() {
        return admin_id;
    }
    
    public void setTotal(String p_total) {
        this.total = p_total;
    }
    
    public String getTotal() {
        return total;
    }
    
    public void setTglTransaksi(String p_tgl_transaksi) {
        this.tgl_transaksi = p_tgl_transaksi;
    }
    
    public String getTglTransaksi() {
        return tgl_transaksi;
    }
}
