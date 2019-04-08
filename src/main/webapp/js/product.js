var prijs = 0;
var waarheid = false;

function loadAanbiedingenProduct() {
	  fetch("/webshop/rest/msg/aanbiedingen/producten")
	  .then(response => response.json())
	  .then(function(myJson) {
		 var tabel = document.getElementById("tabel");
		 
		 for (const object of myJson) {
			 
			 if (object.id == window.sessionStorage.getItem("productid")) {
			 
				 var korting = "0." + object.kortingspercentage;
				 var verschil = (object.prijs * korting);
				 prijs = (object.prijs - verschil);
				 waarheid = true;
			 }
		 }
		 productInfo();
	  });
}

function productInfo() {
	let productId = window.sessionStorage.getItem("productid");
	fetch("rest/msg/" + productId)
	.then(response => response.json())
	.then(function(myJson) {	
		for (const object of myJson) {
//			document.getElementById("productCover").innerHTML = object.cover;
			document.getElementById("productNaam").innerHTML = object.naam;
			document.getElementById("productArtiest").innerHTML = object.artiest;
//			document.getElementById("productCategorie").innerHTML = object.categorie;
			document.getElementById("productBeschrijving").innerHTML = object.beschrijving;
			if (waarheid == false) {
				document.getElementById("productPrijs").innerHTML = "€ " + object.prijs;
			} else if (waarheid == true) {
				document.getElementById("productPrijs").innerHTML = "€ " + prijs;
			}
			let btn = document.createElement("input");
			btn.type = "button";
			btn.value = "Koop";
			btn.name = productId;
			btn.className = "koopknop";
			btn.addEventListener("click", addProduct);
            document.getElementById("button").appendChild(btn);
		}
	});
	
}

function addProduct(){
	let koopKnop = document.getElementsByName(this.name);
	voegToeAanWinkelWagen(this.name);
	let cart = window.localStorage.getItem("shoppingCart");
	for (const item of JSON.parse(cart)) {
		if (item.id == this.name) {
            koopKnop[0].disabled = true;
            koopKnop[0].value = "Product zit al in winkelmand";
        }
    }
}

function initialiseerKnop(){
    let koopKnop = document.getElementsByClassName("koopknop");
    let cart = window.localStorage.getItem("shoppingCart");
    for (const item of JSON.parse(cart)) {
        if (item.id == koopKnop[0].name) {
            koopKnop[0].disabled = true;
            koopKnop[0].value = "Product zit al in winkelmand";
        }
    }
}