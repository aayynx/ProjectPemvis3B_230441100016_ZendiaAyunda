/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sindy
 */
public class LogPembeli {
    private String username, password;
    
    public LogPembeli ( String p_username, String p_password) {
        this.username = p_username;
        this.password = p_password;
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
