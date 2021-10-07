/*const para = document.createElement("p");
const node = document.createTextNode("This is new paragraph");
para.appendChild(node);

const element = document.getElementById("div1");
element.appendChild(para); */

/*var para = document.createElement("p");
var node = document.createTextNode("Tämä on kappaleen teksti");
para.appendChild(node);
document.getElementsByTagName("body")[0].appendChild(para);*/

var divi = document.createElement("div");
//lisaa diviin id "divi"
divi.id = "div1";
document.getElementsByTagName("body")[0].appendChild(divi);

//lisätään kappaletta div#div1 sisään.
var para = document.createElement("p");
para.className = "para1";
var node = document.createTextNode("Lorem ipsum dolor sit amet consectetur adipisicing elit. Libero aspernatur perferendis consequuntur iure sed ut, praesentium, voluptatibus delectus labore deleniti dolor. Commodi laudantium assumenda sint facere fugit unde sed. Officiis, velit distinctio dolore.");
para.appendChild(node);
document.getElementById("div1").appendChild(para);

// lisätään toinen kappalerivi
var para = document.createElement("p");
para.id = "para2";
var node = document.createTextNode("Lorem ipsum dolor sit amet consectetur adipisicing elit. Libero aspernatur perferendis consequuntur iure sed ut, praesentium, voluptatibus delectus labore deleniti dolor.");
para.appendChild(node);
document.getElementById("div1").appendChild(para);


// lisätään kolmas kappale

var para = document.createElement("p");
para.id = "p3";
var node = document.createTextNode("Lorem ipsum dolor sit amet consectetur adipisicing elit. Libero aspernatur perferendis consequuntur iure sed ut, praesentium, voluptatibus delectus labore deleniti dolor.Lorem ipsum dolor sit amet consectetur adipisicing elit. Libero aspernatur perferendis consequuntur iure sed ut, praesentium, voluptatibus delectus labore deleniti dolor.Lorem ipsum dolor sit amet consectetur adipisicing elit. Libero aspernatur perferendis consequuntur iure sed ut, praesentium, voluptatibus delectus labore deleniti dolor.");
para.appendChild(node);
document.getElementById("div1").appendChild(para);
