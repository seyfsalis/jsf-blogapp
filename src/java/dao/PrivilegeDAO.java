/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Privileges;
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
public class PrivilegeDAO extends DBConnect {

    private GroupDAO gdao;

    public List<Privileges> readList() {
        List<Privileges> list = new ArrayList<>();

        try {
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from privilege");

            while (rs.next()) {
                SystemGroup g = this.getGdao().getById(rs.getLong("sgroup"));
                list.add(new Privileges(rs.getLong("id"), g, rs.getString("mname"), rs.getBoolean("icreate"), rs.getBoolean("iread"), rs.getBoolean("iupdate"), rs.getBoolean("idelete"), rs.getBoolean("ilist"), rs.getBoolean("irshow")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public Privileges getGroupPrivilages(SystemGroup sg, String module) {
        Privileges priv = null;

        try {
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from privilege where sgroup=" + sg.getId() + " and mname='" + module + "'");

            rs.next();
            SystemGroup g = this.getGdao().getById(rs.getLong("sgroup"));
            priv = new Privileges(rs.getLong("id"), g, rs.getString("mname"), rs.getBoolean("icreate"), rs.getBoolean("iread"), rs.getBoolean("iupdate"), rs.getBoolean("idelete"), rs.getBoolean("ilist"), rs.getBoolean("irshow"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return priv;
    }

    public void create(Privileges c) {
        try {
            Statement st = this.getConnect().createStatement();
            String query = "insert into privilege(sgroup, mname, icreate, iread, iupdate, idelete, ilist, irshow) values (" + c.getPgroup().getId() + ",'" + c.getMname() + "', " + c.isIcreate() + ", " + c.isIread() + ", " + c.isIupdate() + ", " + c.isIdelete() + ", " + c.isIlist() + ", " + c.isIrshow() + ")";
            System.out.println(query);
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(Privileges c) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("update privilege set title='" + c.getMname() + "' where id=" + c.getId());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Privileges c) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("delete from privilege where id=" + c.getId());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public GroupDAO getGdao() {
        if (this.gdao == null) {
            this.gdao = new GroupDAO();
        }
        return gdao;
    }

    public void setGdao(GroupDAO gdao) {
        this.gdao = gdao;
    }

}
