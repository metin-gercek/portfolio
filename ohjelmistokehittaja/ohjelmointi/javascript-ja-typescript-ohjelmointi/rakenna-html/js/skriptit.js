
/*lisätään header bodyn sisään*/
var header = document.createElement("header");
header.className = "ylatunniste";
header.id = "headerid";
document.getElementsByTagName("body")[0].appendChild(header);

/*lisätään h1 headerin sisään */ 
var h1 = document.createElement("h1");
h1.className = "h1class";
var node = document.createTextNode("Tämä on artikkelin otsikko");
h1.appendChild(node);
document.getElementById("headerid").appendChild(h1);

/*lisätään p headerin sisään */
var para = document.createElement("p");
var node = document.createTextNode("Ensimäinen kappale!. Lorem ipsum dolor sit amet consectetur adipisicing elit. Libero aspernatur perferendis consequuntur iure sed ut, praesentium, voluptatibus delectus labore deleniti dolor. Commodi laudantium assumenda sint facere fugit unde sed. Officiis, velit distinctio dolore. ");
para.appendChild(node);
document.getElementById("headerid").appendChild(para);

/*lisätään section bodyn sisään*/
var section = document.createElement("section");
section.id = "rinnakkain";
document.getElementsByTagName("body")[0].appendChild(section);

/*lisätään p sectionin sisään */
var para1 = document.createElement("p");
para1.className = "pclass";
var node1 = document.createTextNode("Lorem ipsum dolor sit amet consectetur adipisicing elit. Libero aspernatur perferendis consequuntur iure sed ut, praesentium, voluptatibus delectus labore deleniti dolor. Commodi laudantium assumenda sint facere fugit unde sed. Officiis, velit distinctio dolore. ");
para1.appendChild(node1);
document.getElementById("rinnakkain").appendChild(para1);


/*lisätään figure sectionin sisään */
var figure = document.createElement("figure");
figure.id = "kuvanpaikka";
document.getElementById("rinnakkain").appendChild(figure);

/*lisätään img figurein sisään */
var img = document.createElement("img");
img.id = "imgid";
img.src = "images/javascript-machine.gif";
img.alt = "images";
document.getElementById("kuvanpaikka").appendChild(img);


/*lisätään footer bodyn sisään*/
var footer = document.createElement("footer");
footer.id = "footerid";
document.getElementsByTagName("body")[0].appendChild(footer);

/*lisätään p footerin sisään */
var copy = document.createElement("p");
copy.className = "copy";
var node2 = document.createTextNode("@ 2021 Metin Gercek");
copy.appendChild(node2);
document.getElementById("footerid").appendChild(copy);