/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author seyfsalis
 */
public abstract class DBConnect {
    
    private Connection connect;

    public Connection getConnect() {
        if(this.connect == null){
            
            try{
                
                Class.forName("org.postgresql.Driver");
                this.connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/blog", "postgres", "admin123");
                
            }catch(Exception e){
                e.getMessage();
            }
            
        }
        return connect;
    }

    
    
}
