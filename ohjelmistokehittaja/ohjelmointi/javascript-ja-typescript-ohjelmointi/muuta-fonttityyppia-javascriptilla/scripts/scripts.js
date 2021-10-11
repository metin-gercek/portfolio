function changeStyle() {
  var elmnt = document.getElementById("lista");

  var listofFont = ["Courier New", "Roboto", "Mansalva", "Grenze", "Turret Road"];

  if(elmnt.style.fontFamily == listofFont[0]){
    elmnt.style.fontFamily = listofFont[1];
  } else if (elmnt.style.fontFamily == listofFont[1]) {
    elmnt.style.fontFamily = listofFont[2];
  } else if (elmnt.style.fontFamily == listofFont[2]) {
    elmnt.style.fontFamily = listofFont[3];
  } else if (elmnt.style.fontFamily == listofFont[3]) {
    elmnt.style.fontFamily = listofFont[4];
  } else {
    elmnt.style.fontFamily = listofFont[0];
  }
}


//document.getElementById('lista').style.fontFamily = 'Roboto'