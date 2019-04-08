/* JS Document */

/******************************
[Table of Contents]
1. Vars and Inits
2. Set Header
3. Init Menu
4. Init Single Player
******************************/
loadProducten();
loadCategorie();
$(document).ready(function()
{
	"use strict";

	/* 
	1. Vars and Inits
	*/

	var header = $('.header');
	var cdd = $('.custom_dropdown');
	var cddActive = false;

	initMenu();
	initSinglePlayer();

	setHeader();

	$(window).on('resize', function()
	{
		setHeader();

		setTimeout(function()
		{
			$(window).trigger('resize.px.parallax');
		}, 375);
	});

	$(document).on('scroll', function()
	{
		setHeader();
	});

	/* 
	2. Set Header
	*/

	function setHeader()
	{
		if($(window).scrollTop() > 91)
		{
			header.addClass('scrolled');
		}
		else
		{
			header.removeClass('scrolled');
		}
	}
	
	/* 
	3. Init Menu
	*/

	function initMenu()
	{
		if($('.menu').length && $('.hamburger').length)
		{
			var menu = $('.menu');
			var hamburger = $('.hamburger');
			var close = $('.menu_close');

			hamburger.on('click', function()
			{
				menu.toggleClass('active');
			});

			close.on('click', function()
			{
				menu.toggleClass('active');
			});
		}
	}

    /* 
	4. Init Single Player
	*/

	function initSinglePlayer()
	{
		var players = $('.jplayer');
		players.each(function()
		{
			var player = $(this);
			var songTitle = player.data('title');
			var songArtist = player.data('artist');
			var ancestor = player.data('ancestor');
			var songUrl = player.data('url');
			player.jPlayer({
				ready: function () {
					$(this).jPlayer("setMedia", {
						title:songTitle,
						artist:songArtist,
						mp3:songUrl
					});
				},
				play: function() { // To avoid multiple jPlayers playing together.
					$(this).jPlayer("pauseOthers");
				},
				swfPath: "plugins/jPlayer",
				supplied: "mp3",
				cssSelectorAncestor: ancestor,
				wmode: "window",
				globalVolume: false,
				useStateClassSkin: true,
				autoBlur: false,
				smoothPlayBar: true,
				keyEnabled: true,
				solution: 'html',
				preload: 'metadata',
				volume: 0.2,
				muted: false,
				backgroundColor: '#000000',
				errorAlerts: false,
				warningAlerts: false
			});
		});
	}

});

var modal = document.getElementById('myModal');
var btn = document.getElementById("myBtn");
var span = document.getElementsByClassName("close")[0];

 span.onclick = function() {
     modal.style.display = "none";
 }
 window.onclick = function(event) {
     if (event.target == modal) {
         modal.style.display = "none";
     }
 }

function loadProducten() {
	  fetch("rest/msg/producten")
	  .then(response => response.json())
	  .then(function(myJson) {
		 var tabel = document.getElementById("tabel");
		 
		 for (const object of myJson) {
			 var rij = tabel.insertRow(1);
			 
			 var cell1 = rij.insertCell(0);
			 var cell2 = rij.insertCell(1);
			 var cell3 = rij.insertCell(2);
			 var cell4 = rij.insertCell(3);
			 var cell5 = rij.insertCell(4);
			 var cell6 = rij.insertCell(5);
			 var cell7 = rij.insertCell(6);
			 var cell8 = rij.insertCell(7);
			 var cell9 = rij.insertCell(8);
			 var cell10 = rij.insertCell(9);
			 
			 cell1.innerHTML = object.id;
			 cell2.innerHTML = object.naam;
			 cell3.innerHTML = object.artiest;
			 cell4.innerHTML = object.uitgavejaar;
			 cell5.innerHTML = object.beschrijving;
			 cell6.innerHTML = object.categorie;
			 cell7.innerHTML = '€' + object.prijs.toFixed(2);
			 cell8.innerHTML =  object.aanbieding;
			 cell9.innerHTML = '<input class="koopbtn" id="'+ object.id + '" type="submit" value="Koop">';
			 cell10.innerHTML = '<input class="wijzigbtn" id="'+ object.id + '" type="submit" value="Wijzig">';
			 
			 var valueKoop = document.querySelector("#tabel input[value='Koop']");
			valueKoop.addEventListener("click", redirectFunc);
			
			 var valueWijzig = document.querySelector("#tabel input[value='Wijzig']");
			 valueWijzig.addEventListener("click", wijzigFunc);
			 
		 }
	  });
}

function redirectFunc(){
	window.location.href = "http://localhost:8081/webshop/product.html?id=" + this.id;
}

function wijzigFunc(){
 	modal.style.display = "block";
 	fetch("rest/msg/"+ this.id)
 	.then(response => response.json())
 	.then(function(myJson){
		 for (const object of myJson) {
	 	document.getElementById("wijzigGegevens").innerHTML = '<h2> Artikel Wijzigen</h2>';
 		document.getElementById("wijzigGegevens").innerHTML += 'Product ID: <input id="productnr" name="productnr" type="text" value="'+ object.id +  '" readonly><br><br>';
 		document.getElementById("wijzigGegevens").innerHTML += 'Songnaam: <input name="songnaam" type="text" value="'+ object.naam +  '"><br><br>';
 		document.getElementById("wijzigGegevens").innerHTML += 'Artiest: <input name="artiest" type="text" value="'+ object.artiest +  '"><br><br>';
 		document.getElementById("wijzigGegevens").innerHTML += 'Cover: <input name="cover" type="text" value="'+ object.cover +  '"><br><br>';
 		document.getElementById("wijzigGegevens").innerHTML += 'Uitgavejaar: <input name="uitgavejaar" type="number" value="'+ object.uitgavejaar +  '"><br><br>';
 		document.getElementById("wijzigGegevens").innerHTML += 'Genre: <input name="categorie" type="text" value="'+ object.categorie +  '"><br><br>';
 		document.getElementById("wijzigGegevens").innerHTML += 'Verkoopprijs: <input name="prijs" type="number" value="'+ object.prijs +  '"><br><br>';
 		document.getElementById("wijzigGegevens").innerHTML += 'Beschrijving: <input name="beschrijving" type="text" value="'+ object.beschrijving +  '"><br><br>';
 		document.getElementById("wijzigGegevens").innerHTML += '<input id="put" type="submit" value="Wijzig Artikel">';
 		document.getElementById("wijzigGegevens").innerHTML += '<input id="del" type="submit" value="Verwijder Artikel"><br><br>';
		document.querySelector("#put").addEventListener("click", function(){
			updateHandler(object.id);
		});
		document.querySelector("#del").addEventListener("click", function(){
			deleteHandler(object.id);
		});
		 }
 	});
 }

var updateHandler = function(id) {
    var formData = new FormData(document.querySelector("#wijzigGegevens"));
    var encData = new URLSearchParams(formData.entries());
    fetch("rest/msg/" + id, { method: 'PUT', body: encData})
        .then(response => response.json())
        .then(function (myJson) { console.log(myJson); })
};


var deleteHandler = function(id) {
	fetch("rest/msg/" + id, {method: 'DELETE'})
		.then(function (response) {
			if (response.ok) {
				console.log("artikel removed");
				location.reload();
			} else console.log("Unauthorized!");
		})
		.catch(error => console.log(error));
		
}

function loadCategorie() {
	  fetch("rest/msg/categorien")
		.then(response => response.json())
	 	.then(function(myJson){
			 for (const object of myJson) {
	  	document.getElementById("lijst").innerHTML += "<li><a onclick= 'sorteerProductenOpCategorie("+ object.naam +")'>" + object.naam + "</a></li>";
			 }
	 	});
		 	
		 	}

function sorteerProductenOpCategorie(categorie) {
		    fetch("rest/msg/categorien" + categorie)
		  .then(response => response.json())
		  .then(function(myJson) {
			 var tabel = document.getElementById("tabel");

			 while (1 < tabel.rows.length)
			 {
			  tabel.deleteRow(1);
			 }
			 for (const object of myJson) {
				 var rij = tabel.insertRow(1);
				 
				 var cell1 = rij.insertCell(0);
				 var cell2 = rij.insertCell(1);
				 var cell3 = rij.insertCell(2);
				 var cell4 = rij.insertCell(3);
				 var cell5 = rij.insertCell(4);
				 var cell6 = rij.insertCell(5);
				 var cell7 = rij.insertCell(6);
				 var cell8 = rij.insertCell(7);
				 var cell9 = rij.insertCell(8);
				 var cell10 = rij.insertCell(9);
				 
				 cell1.innerHTML = object.id;
				 cell2.innerHTML = object.naam;
				 cell3.innerHTML = object.artiest;
				 cell4.innerHTML = object.uitgavejaar;
				 cell5.innerHTML = object.beschrijving;
				 cell6.innerHTML = object.categorie;
				 cell7.innerHTML = '€' + object.prijs.toFixed(2);
				 cell8.innerHTML =  object.aanbieding;
				 cell9.innerHTML = '<input class="koopbtn" id="'+ object.id + '" type="submit" value="Koop">';
				 cell10.innerHTML = '<input class="wijzigbtn" id="'+ object.id + '" type="submit" value="Wijzig">';
				 
				 var valueKoop = document.querySelector("#tabel input[value='Koop']");
				valueKoop.addEventListener("click", redirectFunc);
				
				 var valueWijzig = document.querySelector("#tabel input[value='Wijzig']");
				 valueWijzig.addEventListener("click", wijzigFunc);
			 }
			 
		  }) .catch(error => alert("Er konden geen producten gevonden worden in deze categorie"));;
}