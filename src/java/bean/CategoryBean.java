/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import dao.CategoryDAO;
import entity.Category;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author seyfsalis
 */
@Named
@SessionScoped
public class CategoryBean implements Serializable {

    private Category entity;
    private CategoryDAO dao;
    private List<Category> list;

    public Category getEntity() {
        if (this.entity == null) {
            this.entity = new Category();
        }
        return entity;
    }

    public void clearForm() {
        this.entity = new Category();
    }
    
    public void create() {
        this.getDao().create(entity);
        this.entity = new Category();
    }
    
    public void update() {
        this.getDao().update(entity);
        this.entity = new Category();
    }
    
    public void delete(){
        this.getDao().delete(entity);
        this.entity = new Category();
    }
    
    public void setEntity(Category entity) {
        this.entity = entity;
    }

    public CategoryDAO getDao() {
        if( this.dao == null ) {
            this.dao = new CategoryDAO();
        }
        return dao;
    }

    public void setDao(CategoryDAO dao) {
        this.dao = dao;
    }

    public List<Category> getList() {
        this.list = this.getDao().readList();
        return list;
    }

    public void setList(List<Category> list) {
        this.list = list;
    }

}
