document.querySelector("body").style.maxWidth = "1140px";
document.querySelector("body").style.margin = "auto";


//luodaan ul class nimi
var element = document.getElementById("unorderlist");
element.classList.add("rivit-vierekkain");

//luodaan tasalukun rivit class nimi
var tableRows = document.getElementsByTagName('tr');
for (var i=0; i < tableRows.length; i++) {
    if (i % 2) {
        tableRows[i].classList.add("joka-toinen-rivi");
    }
    
}
for (var i = 0; i < tableRows.length; i++) {
    tableRows[i].style.backgroundColor = (i % 2)?"#D3D3D3":"#FFF";
}

//luodaan a taggin class nimi
var linkclass = document.links;
for (var i=0; i < linkclass.length; i++) {
    linkclass[i].classList.add("dotted");
}

// flex eka section
const eka_ul = document.getElementById("unorderlist").style.display = "flex";
const ekasection = Array.from(document.querySelectorAll('#unorderlist>li'));
for (var i=0; i<ekasection.length; i++) {
    ekasection[i].style.flexBasis = "33.333%";
    ekasection[i].style.listStyleType = "none";
    ekasection[i].style.marginLeft = "2rem"; 
     

    
}

const graybg = Array.from(document.querySelectorAll("#unorderlist>li>ul"));
for (var i=0; i<graybg.length; i++) {
    graybg[i].style.backgroundColor = "#D3D3D3";
}


var tokatable = document.getElementById("toka").querySelector("table");
tokatable.style.width = "100%";

var kolmastable = document.getElementById("kolmas").querySelector("table");
kolmastable.style.width = "100%";






//last 3 char
linkclass[1].id = 'pdflink';
var last3 = document.getElementById('pdflink').href.substr(-3);
linkclass[1].after("");







