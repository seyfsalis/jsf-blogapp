/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.SystemGroup;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnect;

/**
 *
 * @author seyfsalis
 */
public class GroupDAO extends DBConnect {

    public GroupDAO() {
    }

    public SystemGroup getById(Long id){
        SystemGroup sg = null;
        try{
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from systemgroup where id="+ id);
            rs.next();
            
            sg = new SystemGroup(rs.getLong("id"), rs.getString("gname"), rs.getDate("created"), rs.getDate("updated"));
            
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        
        return sg;
    }
    
    public List<SystemGroup> readList() {
        
        List<SystemGroup> list = new ArrayList<>();

        try {
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from systemgroup");

            while (rs.next()) {
                list.add(new SystemGroup(rs.getLong("id"), rs.getString("gname"), rs.getDate("created"), rs.getDate("updated")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }
    
    public List<SystemGroup> readList(int page) {
        
        int offset = (page-1)*5;
        
        List<SystemGroup> list = new ArrayList<>();

        try {
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from systemgroup limit 5 offset "+offset);

            while (rs.next()) {
                list.add(new SystemGroup(rs.getLong("id"), rs.getString("gname"), rs.getDate("created"), rs.getDate("updated")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public void create(SystemGroup c) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("insert into systemgroup(gname) values ('" + c.getGname() + "')");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(SystemGroup c) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("update systemgroup set gname='" + c.getGname()+ "' where id=" + c.getId());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(SystemGroup c) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("delete from systemgroup where id=" + c.getId());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
