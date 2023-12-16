/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Converter;

import dao.GroupDAO;
import entity.SystemGroup;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author seyfsalis
 */
@FacesConverter("groupConverter")
public class GroupConventer implements Converter {

    private GroupDAO gdao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Long id = Long.valueOf(value);
        return this.getGdao().getById(id);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        SystemGroup sg = (SystemGroup) value;
        return String.valueOf(sg.getId());

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
