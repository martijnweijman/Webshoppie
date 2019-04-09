var PRODUCTEN = [];
var totaalPrijs = 0;

let products = fetch("rest/msg/producten", {method:'GET', mode:'cors'})
    .then(response=>response.json())
    .then(function(jsonProducten){
       for (const item of jsonProducten){
           PRODUCTEN.push(item);
       }
    });


const winkelWagen = {
    KEY: 'shoppingCart',
    content: [],
    init(){
        let _content = window.localStorage.getItem(winkelWagen.KEY);
        if (_content){
            winkelWagen.content = JSON.parse(_content);
        }
        winkelWagen.sync();
    },
    empty(){
        winkelWagen.content = [];
        winkelWagen.sync();
        window.sessionStorage.setItem("totaalPrijs", 0);
        location.reload();
    },
    async sync(){
        let _winkelwagen = JSON.stringify(winkelWagen.content);
        await window.localStorage.setItem(winkelWagen.KEY, _winkelwagen);
    },
    find(id){
        let match = winkelWagen.content.filter(product=>{
            console.log("product" + product);
            if (product.id == id){
                return true;
            }
        });
        if (match && match[0]){
            return match[0];
        }
    },
    add(id){
        console.log(id);
        parseInt(id);
        if (winkelWagen.find(id)){
            alert("Product zit al in winkelmand");
        }else{
            let arr = PRODUCTEN.filter(product=>{
                if(product.id == id){
                    if (window.sessionStorage.getItem("totaalPrijs")) {
                        totaalPrijs = parseFloat(window.sessionStorage.getItem("totaalPrijs")) + product.prijs;
                    }
                    else{
                        totaalPrijs = 0 + product.prijs;
                    }
                    window.sessionStorage.setItem('totaalPrijs', totaalPrijs);
                   return true;
                }
           });
            if (arr && arr[0]){
                let object = {
                    id: arr[0].id,
                    naam: arr[0].naam,
                    artiest: arr[0].artiest,
                    cover: arr[0].cover,
                    uitgavejaar: arr[0].cover,
                    beschrijving: arr[0].beschrijving,
                    categorie: arr[0].categorie,
                    //title: arr[0].title,
                    qty: 1,
                    prijs: arr[0].prijs,
                    aanbieding: arr[0].aanbieding
                };
                winkelWagen.content.push(object);
                winkelWagen.sync();
           }else{
                console.error("Invalid product");
           }
        }
    },
    /*increase(id, qty=1){
        winkelWagen.content = winkelWagen.content.map(product=>{
            if(product.id == id){
                product.qty = product.qty + qty;
                console.log("product qty = " + product.qty);
                return product;
            }
        });
        winkelWagen.sync();
    },*/
    reduce(id){
        for (const stuk of winkelWagen.content){
            if(stuk.id == id){
                let totprijs = parseFloat(window.sessionStorage.getItem('totaalPrijs'));
                totprijs = totprijs - stuk.prijs;
                window.sessionStorage.setItem('totaalPrijs', totprijs);
                winkelWagen.content.pop(stuk);
                removeRow(id);
                winkelWagen.sync();
            }
        }
        /*winkelWagen.content = winkelWagen.content.map(product=>{
            if(product.id == id){
                product.qty = product.qty - qty;
                return product;
            }
        });
        winkelWagen.content.forEach(async product=>{
            if(product.id == id && product.qty == 0){
                await winkelWagen.remove(id);
            }
        });*/
        winkelWagen.sync();
    },
    remove(id){
        winkelWagen.content = winkelWagen.content.filter(product=>{
            if (product.id !== id){
                return true;
            }
        });
        winkelWagen.sync();
    }
};


function voegToeAanWinkelWagen(id){
    //event.preventDefault();
    //let id = parseInt(event.target.getAttribute('data-id'));
   // console.log('voeg item ' + id + ' toe aan winkelwagen');
    winkelWagen.add(id, 1);
}

function verlaagAantal(id){
    console.log(id + ' verwijderd');
    winkelWagen.reduce(parseInt(id), 1);
}

function removeRow(id){
    let cell = document.getElementById('totprijscell');
    let TotPrijs = window.sessionStorage.getItem('totaalPrijs');
    cell.innerHTML = 'Totaalprijs = €' + parseFloat(TotPrijs).toFixed(2);
    let btn = document.getElementById(id);
    let row = btn.parentNode.parentNode;
    row.parentNode.removeChild(row);
}

async function laadWagen(){
    let winkelwagen = [];
    let tabel = document.querySelector("#tabel");
    let btn2 = document.createElement("input");
    let table = document.createElement("table");
    table.id = "winkeltabel";
    let tableHeader2 = document.createElement("th");
    let tableHeader3 = document.createElement("th");
    let tableHeader4 = document.createElement("th");
    let tableHeader5 = document.createElement("th");
    let tableRow = document.createElement("tr");
    btn2.type = "button";
    btn2.value = "-";
    btn2.id = "btn";
    tableHeader2.innerHTML = "Product";
    tableHeader3.innerHTML = "Aantal";
    tableHeader4.innerHTML = "Prijs";
    tableHeader5.innerHTML = "Verlaag";
    tabel.appendChild(table);
    table.appendChild(tableHeader2);
    table.appendChild(tableHeader3);
    table.appendChild(tableHeader4);
    table.appendChild(tableHeader5);
    table.appendChild(tableRow);
    winkelwagen = await window.localStorage.getItem("shoppingCart");
    for (const item of JSON.parse(winkelwagen)) {
        if (item != null) {
            let eindprijs = parseFloat(item.qty) * parseFloat(item.prijs);
            let row = table.insertRow(1);
            let cell1 = row.insertCell(0);
            let cell2 = row.insertCell(1);
            let cell3 = row.insertCell(2);
            let cell4 = row.insertCell(3);
            btn2.id = item.id;
            btn2.className = 'btn';
            btn2.setAttribute("onclick", 'verlaagAantal(this.id)');
            //btn.addEventListener('click', verhoogAantal);
            cell1.innerHTML = item.naam;
            cell2.innerHTML = item.qty;
            cell3.innerHTML = "€" + eindprijs;
            cell4.appendChild(btn2.cloneNode(true));
        }
    }
    let TotPrijs = window.sessionStorage.getItem('totaalPrijs');
    let row = table.insertRow(-1);
    let cell = row.insertCell(-1);
    cell.id = 'totprijscell';
    cell.innerHTML = 'Totaalprijs = €' + parseFloat(TotPrijs).toFixed(2);
    let gooiLeegBtn = document.createElement("input");
    gooiLeegBtn.type = "button";
    gooiLeegBtn.value = "Leeg winkelwagen";
    gooiLeegBtn.addEventListener("click", winkelWagen.empty);
    tabel.appendChild(gooiLeegBtn);
}

function searchPerson(){
    let email = document.getElementById('zoekemailadres').value;
    fetch('', {method: 'GET', mode: 'cors', body: email})
}

function verwerkBestelling(){
    eindWagen = JSON.parse(window.localStorage.getItem('shoppingCart'));
    
}


function addBestellingFunc() {
    console.log("add bestelregel functie");
    var winkelwagen = window.localStorage.getItem("shoppingCart");

    //fetch("webshop/rest/msg/producten", { method: 'POST'})
    fetch("webshop/rest/msg/addbestelregel", { method: 'POST', body: JSON.parse(winkelwagen) })
        .then(response => response.json())
        .then(function (myJson) {console.log(myJson); });
}


