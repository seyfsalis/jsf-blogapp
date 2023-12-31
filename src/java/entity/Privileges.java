/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author seyfsalis
 */
public class Privileges {

    private Long id;
    private SystemGroup pgroup;
    private String mname;
    private boolean icreate;
    private boolean iread;
    private boolean iupdate;
    private boolean idelete;
    private boolean ilist;
    private boolean irshow;

    public Privileges() {
    }

    public Privileges(Long id, SystemGroup g, String mname, boolean icreate, boolean iread, boolean iupdate, boolean idelete, boolean ilist, boolean irshow) {
        this.id = id;
        this.pgroup = g;
        this.mname = mname;
        this.icreate = icreate;
        this.iread = iread;
        this.iupdate = iupdate;
        this.idelete = idelete;
        this.ilist = ilist;
        this.irshow = irshow;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public boolean isIcreate() {
        return icreate;
    }

    public void setIcreate(boolean icreate) {
        this.icreate = icreate;
    }

    public boolean isIread() {
        return iread;
    }

    public void setIread(boolean iread) {
        this.iread = iread;
    }

    public boolean isIupdate() {
        return iupdate;
    }

    public void setIupdate(boolean iupdate) {
        this.iupdate = iupdate;
    }

    public boolean isIdelete() {
        return idelete;
    }

    public void setIdelete(boolean idelete) {
        this.idelete = idelete;
    }

    public boolean isIrshow() {
        return irshow;
    }

    public void setIrshow(boolean irshow) {
        this.irshow = irshow;
    }

    public boolean isIlist() {
        return ilist;
    }

    public void setIlist(boolean ilist) {
        this.ilist = ilist;
    }

    public SystemGroup getPgroup() {
        return pgroup;
    }

    public void setPgroup(SystemGroup pgroup) {
        this.pgroup = pgroup;
    }

}
