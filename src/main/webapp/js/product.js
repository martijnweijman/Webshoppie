function productInfo(id) {
	fetch("rest/msg/" + this.id)
	.then(response => response.json())
	.then(function(myJson) {	
		for (const object of myJson) {
//			document.getElementById("productCover").innerHTML = object.cover;
			document.getElementById("productNaam").innerHTML = object.naam;
			document.getElementById("productArtiest").innerHTML = object.artiest;
//			document.getElementById("productCategorie").innerHTML = object.categorie;
			document.getElementById("productBeschrijving").innerHTML = object.beschrijving;
			document.getElementById("productPrijs").innerHTML = "€ " + object.prijs;
		}
	});
	
}