/* JS Document */

/******************************

[Table of Contents]

1. Vars and Inits
2. Set Header
3. Init Menu
4. Init Single Player


******************************/
loadProducten();
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

function loadProducten() {
	  fetch("restservices/producten")
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
			 
			 cell1.innerHTML = object.productnr;
			 cell2.innerHTML = object.naam;
			 cell3.innerHTML = '€' + object.inkoopprijs.toFixed(2);
			 cell4.innerHTML = '€' + object.verkoopprijs.toFixed(2);
			 cell5.innerHTML = object.categorie;
			 cell6.innerHTML = object.voorraad;
			 cell7.innerHTML = object.levnr;
			 cell8.innerHTML = object.levnr;
			 cell9.innerHTML = '<input class="koopbtn" id="'+ object.productnr + '" type="submit" value="Koop">';
			 
			 valueWijzig.addEventListener("click", sessionStorage.setItem(object.productnr));
			 
		 }
	  });
}
