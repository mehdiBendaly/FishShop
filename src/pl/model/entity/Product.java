package pl.model.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the PRODUCTS database table.
 * 
 */
@Entity
@Table(name="PRODUCTS")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer productid;

	private BigDecimal discontinued;

	private String productname;

	private String quantityperunit;

	private BigDecimal reorderlevel;

	private BigDecimal supplierid;

	private BigDecimal unitprice;

	private BigDecimal unitsinstock;

	private BigDecimal unitsonorder;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="CATEGORYID")
	private Category category;

	public Product() {
	}

	public Integer getProductid() {
		return this.productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public BigDecimal getDiscontinued() {
		return this.discontinued;
	}

	public void setDiscontinued(BigDecimal discontinued) {
		this.discontinued = discontinued;
	}

	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getQuantityperunit() {
		return this.quantityperunit;
	}

	public void setQuantityperunit(String quantityperunit) {
		this.quantityperunit = quantityperunit;
	}

	public BigDecimal getReorderlevel() {
		return this.reorderlevel;
	}

	public void setReorderlevel(BigDecimal reorderlevel) {
		this.reorderlevel = reorderlevel;
	}

	public BigDecimal getSupplierid() {
		return this.supplierid;
	}

	public void setSupplierid(BigDecimal supplierid) {
		this.supplierid = supplierid;
	}

	public BigDecimal getUnitprice() {
		return this.unitprice;
	}

	public void setUnitprice(BigDecimal unitprice) {
		this.unitprice = unitprice;
	}

	public BigDecimal getUnitsinstock() {
		return this.unitsinstock;
	}

	public void setUnitsinstock(BigDecimal unitsinstock) {
		this.unitsinstock = unitsinstock;
	}

	public BigDecimal getUnitsonorder() {
		return this.unitsonorder;
	}

	public void setUnitsonorder(BigDecimal unitsonorder) {
		this.unitsonorder = unitsonorder;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	 @Override
	    public int hashCode() {
	        int hash = 0;
	        hash += (productid != null ? productid.hashCode() : 0);
	        return hash;
	    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.productid == null && other.productid != null) || (this.productid != null && !this.productid.equals(other.productid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "pl.model.entity.Product[ id=" + productid + " ]";
    	return productid.toString();
    }
}