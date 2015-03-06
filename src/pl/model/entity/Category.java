package pl.model.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Set;


/**
 * The persistent class for the CATEGORIES database table.
 * 
 */
@Entity
@Table(name="CATEGORIES")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer categoryid;

	private String categoryname;

	@Lob
	private String description;

	//bi-directional many-to-one association to Obraz
	@OneToMany(mappedBy="category", fetch=FetchType.EAGER)
	private Set<Obraz> obrazs;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="category", fetch=FetchType.EAGER)
	private Set<Product> products;

	public Category() {
	}

	public Integer getCategoryid() {
		return this.categoryid;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryname() {
		return this.categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Obraz> getObrazs() {
		return this.obrazs;
	}

	public void setObrazs(Set<Obraz> obrazs) {
		this.obrazs = obrazs;
	}

	public Obraz addObraz(Obraz obraz) {
		getObrazs().add(obraz);
		obraz.setCategory(this);

		return obraz;
	}

	public Obraz removeObraz(Obraz obraz) {
		getObrazs().remove(obraz);
		obraz.setCategory(null);

		return obraz;
	}

	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setCategory(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setCategory(null);

		return product;
	}
	
	 @Override
	    public int hashCode() {
	        int hash = 0;
	        hash += (categoryid != null ? categoryid.hashCode() : 0);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof Category)) {
	            return false;
	        }
	        Category other = (Category) object;
	        if ((this.categoryid == null && other.categoryid != null) || (this.categoryid != null && !this.categoryid.equals(other.categoryid))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	   //     return "pl.model.entity.Category[ id=" + categoryid + " ]";
	        return categoryid.toString();

	    }
	    

}