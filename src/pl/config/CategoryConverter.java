/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.config;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.persistence.EntityManager;
import pl.model.entity.Category;


public class CategoryConverter implements Converter {

    public Object getAsObject(FacesContext ctx, UIComponent c, String s) {
        Integer i = Integer.valueOf(s);
        EntityManager em = DBManager.getManager().createEntityManager();
        Category p = em.find(Category.class, i);
        em.close();
        return p;
    }

    public String getAsString(FacesContext ctx, UIComponent c, Object o) {
        if(! (o instanceof Category))
            throw new ConverterException(new FacesMessage("Conversion failed!"));
       Category p = (Category) o;
        return p.getCategoryid().toString();
    }
    
}
