/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sindy
 */
public class TambahAdmin {
    private int id;
    private String nama_admin, role, tgl_bergabung;
    
    public TambahAdmin (int p_id, String p_nama_admin, String p_role, String p_tgl_bergabung){
        this.id = p_id;
        this.nama_admin = p_nama_admin;
        this.role = p_role;
        this.tgl_bergabung = p_tgl_bergabung;
    }
    
    public void setId(int p_id) {
        this.id = p_id;
    }
    
    public int getId() {
        return id;
    }
    
    public void setNamaAdmin(String p_nama_admin) {
        this.nama_admin = p_nama_admin;
    }
    
    public String getNamaAdmin() {
        return nama_admin;
    }
    
    public void setRole(String p_role) {
        this.role = p_role;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setTglBergabung(String p_tgl_bergabung) {
        this.tgl_bergabung = p_tgl_bergabung;
    }
    
    public String getTglBergabung() {
        return tgl_bergabung;
    }
}

