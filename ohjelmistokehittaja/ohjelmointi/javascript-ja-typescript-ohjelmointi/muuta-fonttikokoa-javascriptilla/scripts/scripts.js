function changeFont() {
    var element = document.getElementById("lista");
    
    if (element.style.fontSize < "20px") {
        element.style.fontSize = "20px";
    } else if (element.style.fontSize < "24px") {
        element.style.fontSize = "24px";
    } else if (element.style.fontSize < "28px") {
        element.style.fontSize = "28px";
    } else if (element.style.fontSize < "32px") {
        element.style.fontSize = "32px";
    } else {
        element.style.fontSize = "20px";
    }

}