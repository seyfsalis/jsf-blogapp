/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Category;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnect;

/**
 *
 * @author seyfsalis
 */
public class CategoryDAO extends DBConnect {

    public List<Category> readList() {
        List<Category> list = new ArrayList<>();

        try {
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from category");

            while (rs.next()) {
                list.add(new Category(rs.getLong("id"), rs.getString("title"), rs.getDate("created"), rs.getDate("updated")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public void create(Category c) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("insert into category(title) values ('" + c.getTitle() + "')");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(Category c) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("update category set title='" + c.getTitle() + "' where id=" + c.getId());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Category c) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("delete from category where id=" + c.getId());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
