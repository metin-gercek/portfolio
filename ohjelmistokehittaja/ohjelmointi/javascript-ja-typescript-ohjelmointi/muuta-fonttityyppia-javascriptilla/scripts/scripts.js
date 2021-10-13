function changeFont() {
  var fon = document.getElementById("lista");
  if (fon.className == "fontCourier") {
    fon.className = "fontRoboto";
  } else if (fon.className == "fontRoboto") {
    fon.className = "fontMansalva";
  } else if (fon.className == "fontMansalva") {
    fon.className = "fontGrenze";
  } else if (fon.className == "fontGrenze") {
    fon.className = "fontTurret";
  } else {
    fon.className = "fontCourier";
  }
}

