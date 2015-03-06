package pl.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import pl.config.DBManager;
import pl.model.entity.Product;

public class ProductBean {
	private Product product = new Product();

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	//

	public List<Product> getLista() {
		EntityManager em = DBManager.getManager().createEntityManager();
		List list = em.createNamedQuery("Product.findAll").getResultList();
		em.close();
		return list;
	}

	public void productListener(ActionEvent ae) {
		String ids = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("productID").toString();
		int jId = Integer.parseInt(ids);
		this.product.setProductid(jId);
	}

	public String zaladujDoEdycji() {
		EntityManager em = DBManager.getManager().createEntityManager();
		this.product = em.find(Product.class, product.getProductid());
		em.close();
		return "editProduct.xhtml";
	}

	public String usun() {
		EntityManager em = DBManager.getManager().createEntityManager();
		em.getTransaction().begin();
		this.product = em.find(Product.class, product.getProductid());
		em.remove(this.product);
		this.product = new Product();
		em.getTransaction().commit();
		em.close();
		this.dodajInformacje("Product deleted!");
		return null;
	}

	public String dodaj() {
		EntityManager em = DBManager.getManager().createEntityManager();
		em.getTransaction().begin();
		product.setProductid(0);
		em.persist(product);
		em.getTransaction().commit();
		this.dodajInformacje("Product added!");
		em.close();
		this.product = new Product();
		return null;
	}
	

	public String edytuj() {
		EntityManager em = DBManager.getManager().createEntityManager();
		em.getTransaction().begin();
		em.merge(product);
		em.getTransaction().commit();
		em.close();
		this.dodajInformacje("Product changed!");
		this.product = new Product();
		return "pokazProduct.xhtml";
	}

	public void dodajInformacje(String s) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, s, ""));
	}
}
