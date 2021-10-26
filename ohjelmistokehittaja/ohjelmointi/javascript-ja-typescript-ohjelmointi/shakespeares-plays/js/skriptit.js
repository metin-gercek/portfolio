document.querySelector("html").style.fontSize = "62.5%";
document.querySelector("body").style.maxWidth = "1140px";
document.querySelector("body").style.margin = "auto";
document.querySelector("body").style.fontFamily = "Verdana, Geneva, Tahoma, sans-serif";
document.querySelector("body").style.fontSize = "1.6rem";
document.querySelector("body").style.padding = "1rem";

//luodaan ul class nimi
var element = document.getElementById("unorderlist");
element.classList.add("rivit-vierekkain");

//luodaan tasalukun rivit class nimi
var tableRows = document.getElementsByTagName("tr");
for (var i = 0; i < tableRows.length; i++) {
  if (i % 2) {
    tableRows[i].classList.add("joka-toinen-rivi");
  }
}
for (var i = 0; i < tableRows.length; i++) {
  tableRows[i].style.backgroundColor = i % 2 ? "#D3D3D3" : "#FFF";
  tableRows[i].style.backgroundColor = i % 2 ? "#D3D3D3" : "#FFF";
}

//luodaan a taggin class nimi
var linkclass = document.links;
for (var i = 0; i < linkclass.length; i++) {
  linkclass[i].classList.add("dotted");
  linkclass[i].style.color = "#862922";
  linkclass[i].style.fontWeight = "bold";
  linkclass[i].style.fontStyle = "italic";
  linkclass[i].style.textDecoration = "none";
  linkclass[i].style.borderBottom = "0.3rem dotted";


}

// flex eka section
const eka_ul = (document.getElementById("unorderlist").style.display = "flex");
const ekasection = Array.from(document.querySelectorAll("#unorderlist>li"));
for (var i = 0; i < ekasection.length; i++) {
  ekasection[i].style.flexBasis = "33.333%";
  ekasection[i].style.listStyleType = "none";
  ekasection[i].style.marginLeft = "2rem";
}



const graybg = Array.from(document.querySelectorAll("#unorderlist>li>ul"));
for (var i = 0; i < graybg.length; i++) {
  graybg[i].style.backgroundColor = "#D3D3D3";
  graybg[i].style.marginTop = "1rem";
}

document.getElementById("unorderlist").style.lineHeight = "130%";

var tokatable = document.getElementById("toka").querySelector("table");
tokatable.style.width = "100%";

var kolmastable = document.getElementById("kolmas").querySelector("table");
kolmastable.style.width = "100%";

//add icons to links
linkclass[1].id = "pdflink";
var iconpdf = document.getElementById("pdflink");
iconpdf.insertAdjacentHTML("beforeend", '<i class="fas fa-file-pdf"></i>');

linkclass[2].id = "emaillink";
var iconmail = document.getElementById("emaillink");
var orangemail = iconmail.insertAdjacentHTML(
  "afterbegin",
  '<i class="fas fa-envelope" style="color:#EE784F;"></i> <i class="fas fa-external-link-alt" style="color:#6BA86F;"></i>'
);

linkclass[3].id = "externallink";
var iconpdf = document.getElementById("externallink");
iconpdf.insertAdjacentHTML(
  "afterbegin",
  ' <i class="fas fa-external-link-alt" style="color:#6BA86F;"> </i>'
);
