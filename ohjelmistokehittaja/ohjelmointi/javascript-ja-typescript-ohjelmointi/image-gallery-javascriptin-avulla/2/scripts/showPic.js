function showPic(whichpic) {
    var source = whichpic.getAttribute("href");
    var placaholder = document.getElementById("placeholder");
    placaholder.setAttribute("src", source);
}