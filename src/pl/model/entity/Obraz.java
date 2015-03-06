package pl.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the OBRAZ database table.
 * 
 */
@Entity
@NamedQuery(name="Obraz.findAll", query="SELECT o FROM Obraz o")
public class Obraz implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Lob
	private byte[] plik;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="JIDFK")
	private Category category;

	public Obraz() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public byte[] getPlik() {
		return this.plik;
	}

	public void setPlik(byte[] plik) {
		this.plik = plik;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}