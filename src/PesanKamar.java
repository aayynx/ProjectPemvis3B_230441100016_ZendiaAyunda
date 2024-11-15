/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sindy
 */
public class PesanKamar {
    private int id, jumlah_orang;
    private String total, nomor_hp, tipe_kamar, nama_pembeli, tgl_checkin, tgl_checkout, membership, opsi_pembayaran;
    
    public PesanKamar(int p_id, int p_jumlah_orang, String p_total, String p_nomor_hp, String p_tipe_kamar, String p_nama_pembeli, 
            String p_tgl_checkin, String p_tgl_checkout, String p_membership, String p_opsi_Pembayaran){
        this.id = p_id;
        this.jumlah_orang = p_jumlah_orang;
        this.total = p_total;
        this.nomor_hp = p_nomor_hp;
        this.tipe_kamar = p_tipe_kamar;
        this.nama_pembeli = p_nama_pembeli;
        this.tgl_checkin = p_tgl_checkin;
        this.tgl_checkout = p_tgl_checkout;
        this.membership = p_membership;
        this.opsi_pembayaran = p_opsi_Pembayaran; 
        
    }
    
    public void setId(int p_id) {
        this.id = p_id;
    }
    
    public int getId() {
        return id;
    }
    
    public void setNomorHp(String p_nomor_hp) {
        this.nomor_hp = p_nomor_hp;
    }
    
    public String getNomorHp() {
        return nomor_hp;
    }
    
    public void setJumlahOrang(int p_jumlah_orang) {
        this.jumlah_orang = p_jumlah_orang;
    }
    
    public int getJumlahOrang() {
        return jumlah_orang;
    }
    
    public void setTotal(String p_total) {
        this.total = p_total;
    }
    
    public String getTotal() {
        return total;
    }
    
    public void setTipeKamar(String p_tipe_kamar) {
        this.tipe_kamar = p_tipe_kamar;
    }
    
    public String getTipeKamar() {
        return tipe_kamar;
    }
    
    public void setNamaPembeli(String p_nama_pembeli) {
        this.nama_pembeli = p_nama_pembeli;
    }
    
    public String getNamaPembeli() {
        return nama_pembeli;
    }
    
    public void setTglCheckin(String p_tgl_checkin) {
        this.tgl_checkin = p_tgl_checkin;
    }
    
    public String getTglCheckin() {
        return tgl_checkin;
    }
    
    public void setTglCheckout(String p_tgl_checkout) {
        this.tgl_checkout = p_tgl_checkout;
    }
    
    public String getTglCheckout() {
        return tgl_checkout;
    }
    
    public void setMembership(String p_membership) {
        this.membership = p_membership;
    }
    
    public String getMembership() {
        return membership;
    }
    
    public void setOpsiPembayaran(String p_opsi_Pembayaran) {
        this.opsi_pembayaran = p_opsi_Pembayaran;
    }
    
    public String getOpsiPembayaran() {
        return opsi_pembayaran;
    }  
}
