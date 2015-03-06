package pl.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import pl.config.DBManager;
import pl.model.entity.Category;

public class CategoryBean {
	private Category category = new Category();

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	//

	public List<Category> getLista() {
		EntityManager em = DBManager.getManager().createEntityManager();
		List list = em.createNamedQuery("Category.findAll").getResultList();
		em.close();
		return list;
	}

	public void categoryListener(ActionEvent ae) {
		String ids = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("categoryID").toString();
		int jId = Integer.parseInt(ids);
		this.category.setCategoryid(jId);
	}

	public String loadtoEdit() {
		EntityManager em = DBManager.getManager().createEntityManager();
		this.category = em.find(Category.class, category.getCategoryid());
		em.close();
		return "editCategory.xhtml";
	}

	public String delete() {
		EntityManager em = DBManager.getManager().createEntityManager();
		em.getTransaction().begin();
		this.category = em.find(Category.class, category.getCategoryid());
		em.remove(this.category);
		this.category = new Category();
		em.getTransaction().commit();
		em.close();
		this.dodajInformacje("Category is deleted!");
		return null;
	}

	public String add() {
		EntityManager em = DBManager.getManager().createEntityManager();
		em.getTransaction().begin();
		category.setCategoryid(null);
		em.persist(category);
		em.getTransaction().commit();
		this.dodajInformacje("Category added!");
		em.close();
		this.category = new Category();
		return null;
	}

	public String edit() {
		EntityManager em = DBManager.getManager().createEntityManager();
		em.getTransaction().begin();
		em.merge(category);
		em.getTransaction().commit();
		em.close();
		this.dodajInformacje("Category changed!");
		this.category = new Category();
		return "showCategory.xhtml";
	}

	public void dodajInformacje(String s) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, s, ""));
	}
}
