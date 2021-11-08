var myCar = {
    make: 'Ford',
    model: 'Mustang',
    year: 1969
};

function showProps(obj, objName) {
    var result = ``;
    for (var i in obj) {
      // obj.hasOwnProperty() is used to filter out properties from the object's prototype chain
      if (obj.hasOwnProperty(i)) {
        result += `${objName}.${i} = ${obj[i]}\n`;
      }
    }
    return result;
}

function Car(make, model, year) {
  this.make = make;
  this.model = model;
  this.year = year;
}
function Person(name, age, sex) {
  this.name = name;
  this.age = age;
  this.sex = sex;
}

function Car(make, model, year, owner) {
  this.make = make;
  this.model = model;
  this.year = year;
  this.owner = owner;
  this.displayCar = displayCar;
}

var newCar = new Car('Eagle', 'Talon TSi', 1993);
var kenscar = new Car('Nissan', '300ZX', 1992);
var vpgscar = new Car('Mazda', 'Miata', 1990);
var rand = new Person('Rand McKinnon', 33, 'M');
var ken = new Person('Ken Jones', 39, 'M');
var car1 = new Car('Eagle', 'Talon TSi', 1993, rand);
var car2 = new Car('Nissan', '300ZX', 1992, ken);

function displayCar() {
  var result = `A Beautiful ${this.year} ${this.make} ${this.model} owned by ${this.owner.name}`;
  console.log(result);
}



console.log("//Objects and properties");
console.log(myCar);
console.log(newCar);
console.log(kenscar);
console.log(vpgscar);
console.log(typeof myCar);
console.log(showProps(myCar, "myCar"));
console.log(myCar["make"]);

console.log("//Enumerate the properties of an object");
console.log(car1);
console.log(car1.owner.name);
console.log(car2.owner.age);
console.log(kenscar.model);
console.log(kenscar.year);
console.log(kenscar.make);
console.log(vpgscar.model);
console.log(vpgscar.year);
console.log(vpgscar.make);


var cartype = {
  type: 'carType', 
  displayType: function() { 
    console.log(this.type);
  }
};
var sedan = Object.create(cartype);
sedan.type = 'Sedan';
sedan.displayType();
var hatchback = Object.create(cartype);
hatchback.type = 'Hatchback';
hatchback.displayType();
var sw = Object.create(cartype);
sw.type = 'Station Wagon';
sw.displayType();


console.log(car2.displayCar());


const Manager = {
  name: "John",
  age: 27,
  job: "Software Engineer"
}
const Intern = {
  name: "Ben",
  age: 21,
  job: "Software Engineer Intern"
}

function sayHi() {
  console.log('Hello, my name is', this.name + ' I am ' + this.age + ' years old ' + 'and I am working here as a ' + this.job)
}

Manager.sayHi = sayHi;
Intern.sayHi = sayHi;


Manager.sayHi();
Intern.sayHi();


var o = {
  a: 7,
  get b() {
    return this.a + 1;
  },
  set c(x) {
    this.a = x / 2;
  }
};