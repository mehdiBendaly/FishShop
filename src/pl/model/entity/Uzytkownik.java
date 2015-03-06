package pl.model.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the UZYTKOWNIK database table.
 * 
 */
@Entity
@Table(name="UZYTKOWNIK")
@NamedQuery(name="Uzytkownik.findAll", query="SELECT u FROM Uzytkownik u")
public class Uzytkownik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private BigDecimal nidfk;

	private BigDecimal ridfk;

	private String uimie;

	private String umiasto;

	private String unazwisko;

	private String unrlokalu;

	private String upatent;

	private String upesel;

	private String utelefon;

	private String uulica;

	public Uzytkownik() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getNidfk() {
		return this.nidfk;
	}

	public void setNidfk(BigDecimal nidfk) {
		this.nidfk = nidfk;
	}

	public BigDecimal getRidfk() {
		return this.ridfk;
	}

	public void setRidfk(BigDecimal ridfk) {
		this.ridfk = ridfk;
	}

	public String getUimie() {
		return this.uimie;
	}

	public void setUimie(String uimie) {
		this.uimie = uimie;
	}

	public String getUmiasto() {
		return this.umiasto;
	}

	public void setUmiasto(String umiasto) {
		this.umiasto = umiasto;
	}

	public String getUnazwisko() {
		return this.unazwisko;
	}

	public void setUnazwisko(String unazwisko) {
		this.unazwisko = unazwisko;
	}

	public String getUnrlokalu() {
		return this.unrlokalu;
	}

	public void setUnrlokalu(String unrlokalu) {
		this.unrlokalu = unrlokalu;
	}

	public String getUpatent() {
		return this.upatent;
	}

	public void setUpatent(String upatent) {
		this.upatent = upatent;
	}

	public String getUpesel() {
		return this.upesel;
	}

	public void setUpesel(String upesel) {
		this.upesel = upesel;
	}

	public String getUtelefon() {
		return this.utelefon;
	}

	public void setUtelefon(String utelefon) {
		this.utelefon = utelefon;
	}

	public String getUulica() {
		return this.uulica;
	}

	public void setUulica(String uulica) {
		this.uulica = uulica;
	}

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
	
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uzytkownik)) {
            return false;
        }
        Uzytkownik other = (Uzytkownik) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.model.entity.Uzytkownik[ id=" + id + " ]";
    }
}