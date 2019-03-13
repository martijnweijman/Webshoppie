package webshop.domain;

public class Bestellingsregel {
	
	private int id;
	private int aantal;
	private int prijs;
	private Product mijnProduct;
	private Bestelling mijnBestelling;
	
	public Bestellingsregel(int id, int aantal, int prijs, Product mijnProduct, Bestelling mijnBestelling) {
		super();
		this.id = id;
		this.aantal = aantal;
		this.prijs = prijs;
		this.mijnProduct = mijnProduct;
		this.mijnBestelling = mijnBestelling;
	}
	
	public Bestellingsregel(int id, int aantal, int prijs) {
		super();
		this.id = id;
		this.aantal = aantal;
		this.prijs = prijs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAantal() {
		return aantal;
	}

	public void setAantal(int aantal) {
		this.aantal = aantal;
	}

	public int getPrijs() {
		return prijs;
	}

	public void setPrijs(int prijs) {
		this.prijs = prijs;
	}

	public Product getMijnProduct() {
		return mijnProduct;
	}

	public void setMijnProduct(Product mijnProduct) {
		this.mijnProduct = mijnProduct;
	}

	public Bestelling getMijnBestelling() {
		return mijnBestelling;
	}

	public void setMijnBestelling(Bestelling mijnBestelling) {
		this.mijnBestelling = mijnBestelling;
	}
	
	
	
	

}
