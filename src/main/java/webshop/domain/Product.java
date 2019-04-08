package webshop.domain;

public class Product {
	
	private int productID;
	private String productNaam;
	private String artiest;
	private String cover;
	private int uitgavejaar;
	private String productBeschrijving;
	private double productPrijs;
	private Aanbieding mijnAanbieding;
	private String mijnCategory;
	

	public Product(int productID,String productNaam, String artiest, String cover, String mijnCategory, int uitgavejaar,
			String productBeschrijving, int productPrijs) {
		super();
		this.productID = productID;
		this.productNaam = productNaam;
		this.artiest = artiest;
		this.cover = cover;
		this.mijnCategory = mijnCategory;
		this.uitgavejaar = uitgavejaar;
		this.productBeschrijving = productBeschrijving;
		this.productPrijs = productPrijs;
	}

	public Product(int productID,String productNaam, String artiest, String cover, int uitgavejaar,
			String productBeschrijving, int productPrijs, Aanbieding mijnAanbieding, String mijnCategory) {
		super();
		this.productID = productID;
		this.productNaam = productNaam;
		this.artiest = artiest;
		this.cover = cover;
		this.uitgavejaar = uitgavejaar;
		this.productBeschrijving = productBeschrijving;
		this.productPrijs = productPrijs;
		this.mijnAanbieding = mijnAanbieding;
		this.mijnCategory = mijnCategory;
	}

	public String getProductNaam() {
		return productNaam;
	}

	public void setProductNaam(String productNaam) {
		this.productNaam = productNaam;
	}

	public String getProductBeschrijving() {
		return productBeschrijving;
	}

	public void setProductBeschrijving(String productBeschrijving) {
		this.productBeschrijving = productBeschrijving;
	}

	public double getProductPrijs() {
		return productPrijs;
	}

	public void setProductPrijs(int productPrijs) {
		this.productPrijs = productPrijs;
	}

	public Aanbieding getMijnAanbieding() {
		return mijnAanbieding;
	}

	public void setMijnAanbieding(Aanbieding mijnAanbieding) {
		this.mijnAanbieding = mijnAanbieding;
	}

	public String getMijnCategory() {
		return mijnCategory;
	}

	public void setMijnCategory(String mijnCategory) {
		this.mijnCategory = mijnCategory;
	}

	public String getArtiest() {
		return artiest;
	}

	public void setArtiest(String artiest) {
		this.artiest = artiest;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public int getUitgavejaar() {
		return uitgavejaar;
	}

	public void setUitgavejaar(int uitgavejaar) {
		this.uitgavejaar = uitgavejaar;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}
	
}