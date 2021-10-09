function showPic(whichpic) {
    var source = whichpic.getAttribute("href");
    var placaholder = document.getElementById("placeholder");
    placaholder.setAttribute("src", source);
    var text = whichpic.getAttribute("title");
    var description = document.getElementById("description");
    description.firstChild.nodeValue = text;
}
