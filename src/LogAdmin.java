/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sindy
 */
public class LogAdmin {
    private int id;
    private String username, password;
    
    public LogAdmin (int p_id, String p_username, String p_password) {
        this.id = p_id;
        this.username = p_username;
        this.password = p_password;
    }
    
    public void setId(int p_id) {
        this.id = p_id;
    }
    
    public int getId() {
        return id;
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
