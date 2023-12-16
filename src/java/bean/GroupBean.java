/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import dao.GroupDAO;
import entity.Privileges;
import entity.SystemGroup;
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
public class GroupBean implements Serializable {

    private SystemGroup entity;
    private GroupDAO dao;
    private List<SystemGroup> list;

    private int page = 1;
    private int pageCount;

    public SystemGroup getEntity() {
        if (this.entity == null) {
            this.entity = new SystemGroup();
        }
        return entity;
    }

    public void clearForm() {
        this.entity = new SystemGroup();
    }

    public void create() {
        this.getDao().create(entity);
        this.entity = new SystemGroup();
    }

    public void update() {
        this.getDao().update(entity);
        this.entity = new SystemGroup();
    }

    public void delete() {
        this.getDao().delete(entity);
        this.entity = new SystemGroup();
    }

    public void setEntity(SystemGroup entity) {
        this.entity = entity;
    }

    public GroupDAO getDao() {
        if (this.dao == null) {
            this.dao = new GroupDAO();
        }
        return dao;
    }

    public void setDao(GroupDAO dao) {
        this.dao = dao;
    }

    public void previous() {
        page--;
        if (page < 1) {
            page = this.getPageCount();
        }
    }

    public void next() {
        page++;
        if (page > this.getPageCount()) {
            page = 1;
        }
    }

    public List<SystemGroup> getList() {
        this.list = this.getDao().readList(page);
        return list;
    }

    public void setList(List<SystemGroup> list) {
        this.list = list;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageCount() {
        List<SystemGroup> glist = this.getDao().readList();
        int size = glist.size();
        pageCount = (int) Math.ceil(size / 5);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

}
