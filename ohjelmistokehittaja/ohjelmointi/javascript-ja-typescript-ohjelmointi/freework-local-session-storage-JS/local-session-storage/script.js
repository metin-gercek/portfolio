// // LOCAL STORAGE
// let val;

// // set item

const firstName = localStorage.setItem('firstName','Metin');
const lastName = localStorage.setItem('lastName','Gercek');
let hobies = ['cinema','car','reading'];

// get item
val = localStorage.getItem('firstName');
val = localStorage.getItem('lastName');

// remove item
// localStorage.removeItem('firstName');
// localStorage.removeItem('lastName');

// clear
// localStorage.clear();

// set array to storage
localStorage.setItem('hobies',JSON.stringify(hobies));

val = JSON.parse(localStorage.getItem('hobies'));

console.log(val);
console.log(localStorage);


// // SESSION STORAGE
// const city = sessionStorage.setItem('city','Helsinki');
// const country = sessionStorage.setItem('country','Finland');

//  console.log(sessionStorage);