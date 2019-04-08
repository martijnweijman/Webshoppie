package webshop.domain;

import java.util.Date;

public class Aanbieding {
	private int id;
	private Date vanDatum;
	private Date totDatum;
	private int kortingsPercentage;
	private Product mijnProduct;
	
	public Aanbieding(int id, Date vanDatum, Date totDatum, int kortingsPercentage) {
		super();
		this.id = id;
		this.vanDatum = vanDatum;
		this.totDatum = totDatum;
		this.kortingsPercentage = kortingsPercentage;
	}

	public Aanbieding(int id, Date vanDatum, Date totDatum, int kortingsPercentage, Product mijnProduct) {
		super();
		this.id = id;
		this.vanDatum = vanDatum;
		this.totDatum = totDatum;
		this.kortingsPercentage = kortingsPercentage;
		this.mijnProduct = mijnProduct;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getVanDatum() {
		return vanDatum;
	}

	public void setVanDatum(Date vanDatum) {
		this.vanDatum = vanDatum;
	}

	public Date getTotDatum() {
		return totDatum;
	}

	public void setTotDatum(Date totDatum) {
		this.totDatum = totDatum;
	}

	public int getKortingsPercentage() {
		return kortingsPercentage;
	}

	public void setKortingsPercentage(int kortingsPercentage) {
		this.kortingsPercentage = kortingsPercentage;
	}

	public Product getMijnProduct() {
		return mijnProduct;
	}

	public void setMijnProduct(Product mijnProduct) {
		this.mijnProduct = mijnProduct;
	}
}
