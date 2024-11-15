/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sindy
 */
public class LogRegistrasi {
    private int id;
    private String email, username, password;
    
    public LogRegistrasi (int p_id, String p_email, String p_username, String p_password){
        this.id = p_id;
        this.email = p_email;
        this.username = p_username;
        this.password = p_password;
    }
    
    public void setId(int p_id) {
        this.id = p_id;
    }
    
    public int getId() {
        return id;
    }
    
    public void setEmail(String p_email) {
        this.email = p_email;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setUsername(String p_username) {
        this.username = p_username;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setPassword(String p_password) {
        this.password = p_password;
    }
    
    public String getPassword() {
        return password;
    }
}
